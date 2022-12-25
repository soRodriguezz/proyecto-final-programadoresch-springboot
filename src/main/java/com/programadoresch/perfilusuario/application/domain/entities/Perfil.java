package com.programadoresch.perfilusuario.application.domain.entities;


import java.util.List;

public class Perfil {
    private Integer idPerfil;
    private String acercaDe;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Perfil() {
    }

    public Perfil(Integer idPerfil, String acercaDe, String nombre, String apellido, Integer edad) {
        this.idPerfil = idPerfil;
        this.acercaDe = acercaDe;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
