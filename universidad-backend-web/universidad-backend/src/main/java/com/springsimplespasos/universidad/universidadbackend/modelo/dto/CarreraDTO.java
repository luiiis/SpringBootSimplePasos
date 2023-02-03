package com.springsimplespasos.universidad.universidadbackend.modelo.dto;

import lombok.*;

/*@Setter
@Getter
@ToString
@EqualsAndHashCode*/
@Data//tiene todos los anteriores
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {

    private Integer codigo;
    private String  nombre;
    private Integer cantidad_materias;
    private Integer cantidad_anios;


}
