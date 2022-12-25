package com.programadoresch.perfilusuario.infrastructure.models;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Table(name = "perfil")
@Transactional
public class PerfilDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @Column(name = "acerca_de")
    private String acercaDe;

    private String nombre;

    private String apellido;

    private Integer edad;

    @OneToMany(mappedBy = "perfil")
    private List<ConocomientoDAO> conocimiento;

    @OneToMany(mappedBy = "perfil")
    private List<ExperienciaDAO> experiencia;

    @OneToMany(mappedBy = "perfil")
    private List<EducacionDAO> educacion;

    @OneToMany(mappedBy = "perfil")
    private List<LicenciaCertificacionDAO> licenciacertificacion;

    public PerfilDAO() {
    }

    public PerfilDAO(Integer idPerfil, String acercaDe, String nombre, String apellido, Integer edad, List<ConocomientoDAO> conocimiento, List<ExperienciaDAO> experiencia, List<EducacionDAO> educacion, List<LicenciaCertificacionDAO> licenciacertificacion) {
        this.idPerfil = idPerfil;
        this.acercaDe = acercaDe;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.conocimiento = conocimiento;
        this.experiencia = experiencia;
        this.educacion = educacion;
        this.licenciacertificacion = licenciacertificacion;
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

    public List<ConocomientoDAO> getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(List<ConocomientoDAO> conocimiento) {
        this.conocimiento = conocimiento;
    }

    public List<ExperienciaDAO> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<ExperienciaDAO> experiencia) {
        this.experiencia = experiencia;
    }

    public List<EducacionDAO> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<EducacionDAO> educacion) {
        this.educacion = educacion;
    }

    public List<LicenciaCertificacionDAO> getLicenciacertificacion() {
        return licenciacertificacion;
    }

    public void setLicenciacertificacion(List<LicenciaCertificacionDAO> licenciacertificacion) {
        this.licenciacertificacion = licenciacertificacion;
    }
}
