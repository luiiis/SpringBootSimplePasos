package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*@Setter
@Getter
@ToString
@EqualsAndHashCode*/
@Data//tiene todos los anteriores
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "carrera de la universidad",value = "Carrera",reference = "Carrera")
public class CarreraDTO {
    @ApiModelProperty(name="codigo del sistema",example = "5")
    private Integer codigo;
    @NotEmpty(message="Debe de ingresar un valor")
    @Size(min=0,max = 80)
    @ApiModelProperty(name="nombre de la carrera",example = "lic eb Alimentos",required = true)
    //@Pattern(regexp = "")
    //@javax.validation.constraints.
    private String  nombre;
    @Positive(message = "El valor no puede ser negativo")
    @ApiModelProperty(name="cantidad de materias de toda la carrera",example = "55",required = true)
    private Integer cantidad_materias;
    @ApiModelProperty(name="cantidad de años de duracion de la carrera",example = "5",required = true)
    private Integer cantidad_anios;


}
