package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonaDTO {
    private Integer id;
    private String nombre;
    private String apellido;
   @Pattern(regexp = "[0-9]+")
   @Size(min = 1,max = 10)
    private String dni;
    private Direccion direccion;


}
