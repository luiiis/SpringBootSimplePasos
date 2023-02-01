package com.springsimplespasos.conceptosbasicos.inyecciondependecia.domain;

import java.time.LocalDate;

public class Equipo {
    private Integer id;
    private String nombre;
    private Integer anio;
    private LocalDate fechaFundacion;

    public Equipo() {
    }

    public Equipo(Integer id, String nombre, Integer anio, LocalDate fechaFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.fechaFundacion = fechaFundacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", fechaFundacion=" + fechaFundacion +
                '}';
    }
}
