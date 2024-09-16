package edu.jdc.VisionPlus.clases;

import java.util.Date;
import java.util.Objects;

public class Usuarios extends Roles {
    private Integer idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String claveUsuario;
    private Date  fechaCreacion;
    private String telefonoUsuario;
    private String direccionUsuario;
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
