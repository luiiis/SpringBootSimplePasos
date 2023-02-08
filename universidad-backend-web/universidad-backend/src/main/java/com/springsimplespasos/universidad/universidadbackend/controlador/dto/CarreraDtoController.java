package com.springsimplespasos.universidad.universidadbackend.controlador.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app",name="controller.enable-dto",havingValue = "true")
@Api(value="Acciones relacionadas con las carreras",tags="acciones sobre carreras")
public class CarreraDtoController extends GenericDtoController<Carrera,CarreraDAO>
{  @Autowired
    private CarreraMapperMS mapper;
    public CarreraDtoController(CarreraDAO service){
        super(service,"Carrera");
    }
@GetMapping
@ApiOperation(value = "Consultar todas las carreras")
@ApiResponses({
        @ApiResponse(code = 200,message = "Ejecutado satisfactoriamente")
})
    public ResponseEntity<?> obtenerCarreras(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Carrera> carreras = super.obtenerTodos();
        if(carreras.isEmpty()){
            mensaje.put("success",Boolean.FALSE);
            mensaje.put("mensaje",String.format("No se encontraron %ss cargadas",nombre_entidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
       List<CarreraDTO> carrerDTOS= carreras.stream().map(mapper::mapCarrera).collect(Collectors.toList());
       mensaje.put("success",Boolean.TRUE);
       mensaje.put("data",carrerDTOS);
       return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar carrera por codigo")
    public ResponseEntity<?> obtenerCarreraPorId(@PathVariable @ApiParam(name = "codigo del sistema") Integer id){
        return ResponseEntity.ok("");
    }
}
