package edu.jdc.VisionPlus.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
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
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cod_rol", nullable = false)
    public Rol rolUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String ApellidoUsuario, String correoUsuario, String contrasenaUsuario, Date fechaCreacionUsuario, String telefonoUsuario, String direccionUsuario, Integer estadoUsuario, Rol rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.ApellidoUsuario = ApellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.estadoUsuario = estadoUsuario;
        this.rolUsuario = rolUsuario;
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

    public String getApellidoUsuario() {
        return ApellidoUsuario;
    }

    public void setApellidoUsuario(String ApellidoUsuario) {
        this.ApellidoUsuario = ApellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
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

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.idUsuario, other.idUsuario);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", ApellidoUsuario=" + ApellidoUsuario + ", correoUsuario=" + correoUsuario + ", contrasenaUsuario=" + contrasenaUsuario + ", fechaCreacionUsuario=" + fechaCreacionUsuario + ", telefonoUsuario=" + telefonoUsuario + ", direccionUsuario=" + direccionUsuario + ", estadoUsuario=" + estadoUsuario + '}';
    }

    
    
    
    
}
