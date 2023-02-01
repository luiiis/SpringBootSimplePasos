package com.springsimplespasos.conceptosbasicos.inyecciondependecia.service;

import com.springsimplespasos.conceptosbasicos.inyecciondependecia.domain.Equipo;

import java.util.Optional;

public interface EquipoService {

    Optional<Equipo> obtenerEquipoPorId(Integer id);
    Iterable<Equipo> obtenerTodos();
}
