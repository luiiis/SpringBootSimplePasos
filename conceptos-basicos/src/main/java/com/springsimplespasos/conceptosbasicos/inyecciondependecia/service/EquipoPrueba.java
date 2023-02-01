package com.springsimplespasos.conceptosbasicos.inyecciondependecia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EquipoPrueba implements CommandLineRunner {
    @Autowired
    @Qualifier("equipo-argentina")//nos ayuda a utilizar el componente a utilizar
    EquipoService equipoService;
    @Override
    public void run(String... args) throws Exception {
        equipoService.obtenerTodos().forEach(System.out::println);
    }
}
