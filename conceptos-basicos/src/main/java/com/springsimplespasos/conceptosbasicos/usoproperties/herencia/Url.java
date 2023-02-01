package com.springsimplespasos.conceptosbasicos.usoproperties.herencia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class Url {
    private String client;
    private String customer;

    public String getClient() {
        return client;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
