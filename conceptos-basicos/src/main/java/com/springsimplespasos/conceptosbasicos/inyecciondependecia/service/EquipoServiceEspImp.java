package com.springsimplespasos.conceptosbasicos.inyecciondependecia.service;

import com.springsimplespasos.conceptosbasicos.inyecciondependecia.domain.Equipo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//@Primary
@Component("equipo-espania")
@ConditionalOnProperty(prefix = "app",name="implementacion",havingValue = "espania")
public class EquipoServiceEspImp implements EquipoService{
    private List<Equipo> equipos = new ArrayList<>(Arrays.asList(
            new Equipo(1,"Luis Eduardo",1906, LocalDate.of(1901,8,25)),
            new Equipo(2,"Jose Juan",1907, LocalDate.of(1902,9,26)),
            new Equipo(3,"Jesus Omar",1908, LocalDate.of(1903,10,27))
    ));
    @Override
    public Optional<Equipo> obtenerEquipoPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Equipo> obtenerTodos() {
        return this.equipos;
    }
}
