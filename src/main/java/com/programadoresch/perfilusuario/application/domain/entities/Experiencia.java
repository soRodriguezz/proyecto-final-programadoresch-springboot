package com.programadoresch.perfilusuario.application.domain.entities;

public class Experiencia {
    private int idExperiencia;
    private String cargo;
    private String nombreEmpresa;
    private String ubicacion;
    private int mesInicio;
    private int annoInicio;
    private int mesFin;
    private int annoFin;
    private int idPerfil;
    private Perfil perfil;
    public Experiencia() {
    }

    public Experiencia(int idExperiencia, String cargo, String nombreEmpresa, String ubicacion, int mesInicio, int annoInicio, int mesFin, int annoFin, int idPerfil, Perfil perfil) {
        this.idExperiencia = idExperiencia;
        this.cargo = cargo;
        this.nombreEmpresa = nombreEmpresa;
        this.ubicacion = ubicacion;
        this.mesInicio = mesInicio;
        this.annoInicio = annoInicio;
        this.mesFin = mesFin;
        this.annoFin = annoFin;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(int mesInicio) {
        this.mesInicio = mesInicio;
    }

    public int getAnnoInicio() {
        return annoInicio;
    }

    public void setAnnoInicio(int annoInicio) {
        this.annoInicio = annoInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public void setMesFin(int mesFin) {
        this.mesFin = mesFin;
    }

    public int getAnnoFin() {
        return annoFin;
    }

    public void setAnnoFin(int annoFin) {
        this.annoFin = annoFin;
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
