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

@Entity
@Table(name="Usuarios")
public class Usuarios extends Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Usuario")
    private Integer idUsuario;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="nombre_Usuario")
    private String nombreUsuario;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="apellido_Usuario")
    private String apellidoUsuario;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="correo_Usuario")
    private String correoUsuario;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="clave_Usuario")
    private String claveUsuario;
    
    @NotNull
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_Creacion")
    private Date  fechaCreacion;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="telefono_Usuario")
    private String telefonoUsuario;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="direccion_Usuario")
    private String direccionUsuario;
    
    @NotNull
    @Column(name="estado_Usuario")
    private Integer estadoUsuario;
    
    public Usuarios(){
        
    }
    public Usuarios(Integer idRol, Integer idUsuario, String nombreUsuario, String apellidoUsuario,String correoUsuario, 
            String claveUsuario, Date fechaCreacion, String telefonoUsuario, String direccionUsuario,Integer estadoUsuario){
        this.idUsuario=idUsuario;
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.correoUsuario=correoUsuario;
        this.claveUsuario=claveUsuario;
        this.fechaCreacion=fechaCreacion;
        this.telefonoUsuario=telefonoUsuario;
        this.direccionUsuario=direccionUsuario;
        this.estadoUsuario=estadoUsuario;
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
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idUsuario);
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
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", correoUsuario=" + correoUsuario + ", claveUsuario=" + claveUsuario + ", fechaCreacion=" + fechaCreacion + ", telefonoUsuario=" + telefonoUsuario + ", direccionUsuario=" + direccionUsuario + ", estadoUsuario=" + estadoUsuario + '}';
    }
    
}
