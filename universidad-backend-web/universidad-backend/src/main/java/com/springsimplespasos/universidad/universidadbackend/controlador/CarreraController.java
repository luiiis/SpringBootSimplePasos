package com.springsimplespasos.universidad.universidadbackend.controlador;

import com.springsimplespasos.universidad.universidadbackend.exception.BadRequestException;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraDAO carreraDAO;
    @Autowired
    public CarreraController(CarreraDAO carreraDao){
        this.carreraDAO=carreraDao;
    }
  @GetMapping
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        if(carreras.isEmpty()){
            throw new BadRequestException("no Existen carreras");
        }
        return carreras;
    }
@GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo",required = false) Integer id){
        Optional<Carrera> oCarrera=carreraDAO.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id no existe: "+id));
        }
        return oCarrera.get();
    }
    @PostMapping
public Carrera altaCarrera(@RequestBody Carrera carrera)
{
   return carreraDAO.save(carrera);
}
}
