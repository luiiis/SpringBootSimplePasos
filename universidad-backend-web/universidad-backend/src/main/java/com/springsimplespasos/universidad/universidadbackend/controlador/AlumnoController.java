package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Persona;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final PersonaDAO alumnoDao;

    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO alumnoDao){
        this.alumnoDao=alumnoDao;
    }
    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDao.save(alumno);
    }
}
