package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

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
public class CarreraDTO {
    @NotNull
    private Integer codigo;
    @NotEmpty(message="Debe de ingresar un valor")
    @Size(min=0,max = 80)
    //@Pattern(regexp = "")
    //@javax.validation.constraints.
    private String  nombre;
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidad_materias;
    private Integer cantidad_anios;


}
