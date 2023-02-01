package com.springsimplespasos.conceptosbasicos.usoyaml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebaYaml implements CommandLineRunner
{   @Autowired
    ReadYaml readYaml;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------------------------------------------------------------------YAML---------");
        System.out.println("servidor.aplicacion.nombre: "+readYaml.getAplicacion().get("nombre"));
        readYaml.getConfiguracion().get("ips").forEach(System.out::println);
        readYaml.getConfiguracion().get("files-system").forEach(System.out::println);
        System.out.println("usuario root username: "+readYaml.getUsuarios().get("root").getUsername()
                +"; password: "+readYaml.getUsuarios().get("root").getPassword());
    }
}
