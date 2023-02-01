package com.springsimplespasos.conceptosbasicos.usoproperties.herencia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:bar.properties")
@ConfigurationProperties(prefix = "bar")
public class ReadBarProperties {

    private String name;
    private Url url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }
}
