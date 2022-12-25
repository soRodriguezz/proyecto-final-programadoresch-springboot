package com.programadoresch.perfilusuario.infrastructure.models;

import javax.persistence.*;

@Entity
@Table(name = "educacion")
public class EducacionDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_educacion")
    private Integer idEducacion;

    private String institucion;

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

    public EducacionDAO() {
    }

    public EducacionDAO(Integer idEducacion, String institucion, Integer mesInicio, Integer annoInicio, Integer mesFin, Integer annoFin, Integer idPerfil, PerfilDAO perfil) {
        this.idEducacion = idEducacion;
        this.institucion = institucion;
        this.mesInicio = mesInicio;
        this.annoInicio = annoInicio;
        this.mesFin = mesFin;
        this.annoFin = annoFin;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public Integer getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(Integer idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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
