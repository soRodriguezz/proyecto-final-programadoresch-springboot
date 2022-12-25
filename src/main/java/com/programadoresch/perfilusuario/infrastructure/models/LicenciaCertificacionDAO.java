package com.programadoresch.perfilusuario.infrastructure.models;

import javax.persistence.*;

@Entity
@Table(name = "licencia_certificacion")
public class LicenciaCertificacionDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licencia_certificacion")
    private Integer idLicenciaCertificacion;

    @Column(name = "nombre_certificado")
    private String nombreCertificado;

    @Column(name = "empresa_emisora")
    private String empresaEmisora;

    @Column(name = "url_certificado")
    private String urlCertificado;

    @Column(name = "mes_inicio")
    private Integer mesInicio;

    @Column(name = "anno_inicio")
    private Integer annoInicio;

    @Column(name = "mes_fin")
    private Integer mesFin;

    @Column(name = "anno_fin")
    private Integer annoFin;

    @Column(name = "id_perfil")
    private Integer idPerfil;

    @ManyToOne
    @JoinColumn(name = "fk_id_perfil")
    private PerfilDAO perfil;

    public LicenciaCertificacionDAO() {
    }

    public LicenciaCertificacionDAO(Integer idLicenciaCertificacion, String nombreCertificado, String empresaEmisora, String urlCertificado, Integer mesInicio, Integer annoInicio, Integer mesFin, Integer annoFin, Integer idPerfil, PerfilDAO perfil) {
        this.idLicenciaCertificacion = idLicenciaCertificacion;
        this.nombreCertificado = nombreCertificado;
        this.empresaEmisora = empresaEmisora;
        this.urlCertificado = urlCertificado;
        this.mesInicio = mesInicio;
        this.annoInicio = annoInicio;
        this.mesFin = mesFin;
        this.annoFin = annoFin;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public Integer getIdLicenciaCertificacion() {
        return idLicenciaCertificacion;
    }

    public void setIdLicenciaCertificacion(Integer idLicenciaCertificacion) {
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

    public Integer getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(Integer mesInicio) {
        this.mesInicio = mesInicio;
    }

    public Integer getAnnoInicio() {
        return annoInicio;
    }

    public void setAnnoInicio(Integer annoInicio) {
        this.annoInicio = annoInicio;
    }

    public Integer getMesFin() {
        return mesFin;
    }

    public void setMesFin(Integer mesFin) {
        this.mesFin = mesFin;
    }

    public Integer getAnnoFin() {
        return annoFin;
    }

    public void setAnnoFin(Integer annoFin) {
        this.annoFin = annoFin;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public PerfilDAO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDAO perfil) {
        this.perfil = perfil;
    }
}
