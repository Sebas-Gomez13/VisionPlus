/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.VisionPlus.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author julic
 */
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Helado")
    private Integer idUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "apellidoUsuario")
    private String ApellidoUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "correoUsuario")
    private String correoUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "contrasenaUsuario")
    private String contrasenaUsuario;
    
    @NotNull
    @Column(name = "fechaCreacionUsuario")
    private Date fechaCreacionUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "telefonoUsuario")
    private String telefonoUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "direccionUsuario")
    private String direccionUsuario;
    
    @NotNull
    @Column(name = "estadoUsuario")
    private Integer estadoUsuario;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, String nombreUsuario, String ApellidoUsuaeio, String correoUsuaeio, String contrasenaUsuario, Date fechaCreacionUsuario, String telefonoUsuario, String direccionUsuario, Integer estadoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.ApellidoUsuario = ApellidoUsuaeio;
        this.correoUsuario = correoUsuaeio;
        this.contrasenaUsuario = contrasenaUsuario;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuaeio() {
        return ApellidoUsuario;
    }

    public void setApellidoUsuaeio(String ApellidoUsuaeio) {
        this.ApellidoUsuario = ApellidoUsuaeio;
    }

    public String getCorreoUsuaeio() {
        return correoUsuario;
    }

    public void setCorreoUsuaeio(String correoUsuaeio) {
        this.correoUsuario = correoUsuaeio;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Integer getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Integer estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuarios other = (Usuarios) obj;
        return Objects.equals(this.idUsuario, other.idUsuario);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", ApellidoUsuario=" + ApellidoUsuario + ", correoUsuario=" + correoUsuario + ", contrasenaUsuario=" + contrasenaUsuario + ", fechaCreacionUsuario=" + fechaCreacionUsuario + ", telefonoUsuario=" + telefonoUsuario + ", direccionUsuario=" + direccionUsuario + ", estadoUsuario=" + estadoUsuario + '}';
    }

    
    
    
    
}
