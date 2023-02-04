package com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springsimplespasos.universidad.universidadbackend.modelo.dto.EmpleadoDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Empleado;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;

@MapperConfig
public interface EmpleadoMapperConfig extends PersonaMapperConfig{
    @InheritConfiguration(name = "mapPersona")
    void mapEmpleado(Empleado empleado, EmpleadoDTO empleadoDTO);
}
