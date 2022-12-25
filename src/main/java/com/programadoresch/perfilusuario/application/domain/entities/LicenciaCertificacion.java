package com.programadoresch.perfilusuario.application.domain.entities;

public class LicenciaCertificacion {
    private int idLicenciaCertificacion;
    private String nombreCertificado;
    private String empresaEmisora;
    private String urlCertificado;
    private int mesInicio;
    private int annoInicio;
    private int mesFin;
    private int annoFin;
    private int idPerfil;
    private Perfil perfil;

    public LicenciaCertificacion() {
    }

    public int getIdLicenciaCertificacion() {
        return idLicenciaCertificacion;
    }

    public void setIdLicenciaCertificacion(int idLicenciaCertificacion) {
        this.idLicenciaCertificacion = idLicenciaCertificacion;
    }

    public String getNombreCertificado() {
        return nombreCertificado;
    }

    public void setNombreCertificado(String nombreCertificado) {
        this.nombreCertificado = nombreCertificado;
    }

    public String getEmpresaEmisora() {
        return empresaEmisora;
    }

    public void setEmpresaEmisora(String empresaEmisora) {
        this.empresaEmisora = empresaEmisora;
    }

    public String getUrlCertificado() {
        return urlCertificado;
    }

    public void setUrlCertificado(String urlCertificado) {
        this.urlCertificado = urlCertificado;
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
