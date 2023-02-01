package com.springsimplespasos.conceptosbasicos.usoproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration//nos tiene que generar un tipo de componente
public class ReadCommonProperties {
    @Value("${app.base.url}")//accede al valor del properties
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }
}
