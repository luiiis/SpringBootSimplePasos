package com.springsimplespasos.conceptosbasicos.usoyaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix="servidor")
@PropertySource(value="classpath:servidor.yml",factory = YamlPropertySourceFactory.class)
public class ReadYaml {

    private Map<String,String> aplicacion;
    private Map<String, List<String>> configuracion;
    private Map<String,Usuario> usuarios;

    public Map<String, String> getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Map<String, String> aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Map<String, List<String>> getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Map<String, List<String>> configuracion) {
        this.configuracion = configuracion;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
