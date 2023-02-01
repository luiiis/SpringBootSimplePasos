package com.springsimplespasos.conceptosbasicos.usoproperties;

import com.springsimplespasos.conceptosbasicos.usoproperties.herencia.ReadBarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PruebaProperties implements CommandLineRunner {
    @Autowired
    ReadCommonProperties commonProperties;
    @Autowired
    ReadFooProperties fooProperties;
    @Autowired
    ReadBarProperties barProperties;
    @Override
    public void run(String... args) throws Exception{

        System.out.println("app.base.url: "+ commonProperties.getBaseUrl());
        System.out.println("----------------------------------------------");
        System.out.println("app.foo.client: "+ fooProperties.getClientURL());
        System.out.println("app.foo.customer: "+ fooProperties.getCustomerUrl());
        System.out.println("----------------------------------------------");
        System.out.println("bar.name : "+ barProperties.getName());
        System.out.println("bar.url.client : "+ barProperties.getUrl().getClient());
        System.out.println("bar.url.customer : "+ barProperties.getUrl().getCustomer());

    }
}
