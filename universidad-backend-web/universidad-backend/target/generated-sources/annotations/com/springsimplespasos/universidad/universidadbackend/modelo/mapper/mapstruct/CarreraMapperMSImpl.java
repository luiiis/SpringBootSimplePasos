package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Carrera;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-08T02:56:04+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class CarreraMapperMSImpl implements CarreraMapperMS {

    @Override
    public CarreraDTO mapCarrera(Carrera carrera) {
        if ( carrera == null ) {
            return null;
        }

        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setCodigo( carrera.getId() );
        carreraDTO.setCantidad_materias( carrera.getCantidaMaterias() );
        carreraDTO.setCantidad_anios( carrera.getCantidadAnios() );
        carreraDTO.setNombre( carrera.getNombre() );

        return carreraDTO;
    }
}
