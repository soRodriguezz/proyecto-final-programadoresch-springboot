package com.programadoresch.perfilusuario.infrastructure.models;

import javax.persistence.*;

@Entity
@Table(name = "experiencia")
public class ExperienciaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia")
    private Integer idExperiencia;

    private String cargo;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    private String ubicacion;

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

    public ExperienciaDAO() {
    }

    public ExperienciaDAO(Integer idExperiencia, String cargo, String nombreEmpresa, String ubicacion, Integer mesInicio, Integer annoInicio, Integer mesFin, Integer annoFin, Integer idPerfil, PerfilDAO perfil) {
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

    public Integer getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(Integer idExperiencia) {
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
