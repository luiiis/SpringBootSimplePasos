package com.springsimplespasos.conceptosbasicos.usoproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebaProperties implements CommandLineRunner {
    @Autowired
    ReadCommonProperties commonProperties;
    @Override
    public void run(String... args) throws Exception{
        System.out.println("app.base.url: "+ commonProperties.getBaseUrl());

    }
}
