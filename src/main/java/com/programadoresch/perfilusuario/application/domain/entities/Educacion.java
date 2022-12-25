package com.programadoresch.perfilusuario.application.domain.entities;

public class Educacion {
    private int idEducacion;
    private String institucion;
    private int mesInicio;
    private int annoInicio;
    private int mesFin;
    private int annoFin;
    private int idPerfil;
    private Perfil perfil;

    public Educacion() {
    }

    public Educacion(int idEducacion, String institucion, int mesInicio, int annoInicio, int mesFin, int annoFin, int idPerfil, Perfil perfil) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.mesInicio = mesInicio;
        this.annoInicio = annoInicio;
        this.mesFin = mesFin;
        this.annoFin = annoFin;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public int getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(int idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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
