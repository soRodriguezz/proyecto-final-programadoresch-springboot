package com.programadoresch.perfilusuario.infrastructure.models;

import javax.persistence.*;

@Entity
@Table(name = "conocimiento")
public class ConocomientoDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conocimiento")
    private Integer idConocimiento;

    private String aptitud;

    @Column(name = "id_perfil")
    private Integer idPerfil;

    @ManyToOne
    @JoinColumn(name = "fk_id_perfil")
    private PerfilDAO perfil;

    public ConocomientoDAO() {
    }

    public ConocomientoDAO(Integer idConocimiento, String aptitud, Integer idPerfil, PerfilDAO perfil) {
        this.idConocimiento = idConocimiento;
        this.aptitud = aptitud;
        this.idPerfil = idPerfil;
        this.perfil = perfil;
    }

    public Integer getIdConocimiento() {
        return idConocimiento;
    }

    public void setIdConocimiento(Integer idConocimiento) {
        this.idConocimiento = idConocimiento;
    }

    public String getAptitud() {
        return aptitud;
    }

    public void setAptitud(String aptitud) {
        this.aptitud = aptitud;
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
