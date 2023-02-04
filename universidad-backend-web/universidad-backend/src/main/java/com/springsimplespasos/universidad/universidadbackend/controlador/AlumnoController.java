package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app",name="controller.enable-dto",havingValue = "false")
public class AlumnoController extends PersonaController{


    private final CarreraDAO carreraDAO;

    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO alumnoDao, CarreraDAO carreraDAO){
        super(alumnoDao);
        nombreEntidad="Alumno";
        this.carreraDAO = carreraDAO;
    }
    /*
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

     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumnos(@PathVariable Integer id, @RequestBody Persona persona){
        Map<String,Object> mensaje = new HashMap<>();
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno=service.findById(id);
        if(!oAlumno.isPresent()){
            //throw new BadRequestException(String.format("Alumno con id no existe "+id));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Alumno con id no existe "+id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate=oAlumno.get();
        alumnoUpdate.setNombre(persona.getNombre());
        alumnoUpdate.setApellido(persona.getApellido());
        alumnoUpdate.setDireccion(persona.getDireccion());

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(alumnoUpdate));
        return ResponseEntity.ok(mensaje);
    }
    /*
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }

     */
    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String,Object> mensaje = new HashMap<>();
        Optional<Persona> oAlumno=service.findById(idAlumno);
        if(!oAlumno.isPresent()){
            //throw new BadRequestException(String.format("Alumno con id no existe "+idAlumno));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Alumno con id no existe "+idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Optional<Carrera>oCarrer= carreraDAO.findById(idCarrera);
        if(!oCarrer.isPresent()){
            //throw new BadRequestException(String.format("Carrera con id %d no existe ",idCarrera));
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrera con id %d no existe ",idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Persona alumno = oAlumno.get();
        Carrera carrera=oCarrer.get();
        ((Alumno)alumno).setCarrera(carrera);

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",service.save(alumno));
        return ResponseEntity.ok(mensaje);
    }
}
