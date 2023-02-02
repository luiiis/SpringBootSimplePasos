package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final PersonaDAO alumnoDao;

    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO alumnoDao){
        this.alumnoDao=alumnoDao;
    }
    @GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();
        if(alumnos.isEmpty()){
            throw new BadRequestException("No existe alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoporId(@PathVariable(required = false) Integer id){
       Optional<Persona> oAlumno= this.alumnoDao.findById(id);
       if(!oAlumno.isPresent()){
           throw new BadRequestException(String.format("Alumno con id no existe "+id));
       }
       return oAlumno.get();
    }
    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDao.save(alumno);
    }
    @PutMapping("/{id}")
    public Persona actualizarAlumnos(@PathVariable Integer id,@RequestBody Persona persona){
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno=alumnoDao.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("Alumno con id no existe "+id));
        }
        alumnoUpdate=oAlumno.get();
        alumnoUpdate.setNombre(persona.getNombre());
        alumnoUpdate.setApellido(persona.getApellido());
        alumnoUpdate.setDireccion(persona.getDireccion());
        return alumnoDao.save(alumnoUpdate);
    }
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }
}
