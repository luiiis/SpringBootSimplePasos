package com.springsimplespasos.conceptosbasicos.usoproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebaProperties implements CommandLineRunner {
    @Autowired
    ReadCommonProperties commonProperties;
    @Autowired
    ReadFooProperties fooProperties;
    @Override
    public void run(String... args) throws Exception{

        System.out.println("app.base.url: "+ commonProperties.getBaseUrl());
        System.out.println("----------------------------------------------");
        System.out.println("app.foo.client: "+ fooProperties.getClientURL());
        System.out.println("app.foo.customer: "+ fooProperties.getCustomerUrl());

    }
}
