package com.programadoresch.perfilusuario.application.domain.entities;

public class Conocimiento {
    private int idConocimiento;
    private String aptitud;

    private int idPerfil;
    private Perfil perfil;

    public Conocimiento() {
    }

    public Conocimiento(int idConocimiento, String aptitud, int idPerfil, Perfil perfil) {
        this.idConocimiento = idConocimiento;
        this.aptitud = aptitud;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public int getIdConocimiento() {
        return idConocimiento;
    }

    public void setIdConocimiento(int idConocimiento) {
        this.idConocimiento = idConocimiento;
    }

    public String getAptitud() {
        return aptitud;
    }

    public void setAptitud(String aptitud) {
        this.aptitud = aptitud;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
