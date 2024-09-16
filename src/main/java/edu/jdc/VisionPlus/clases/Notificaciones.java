package edu.jdc.VisionPlus.clases;

import java.util.Date;
import java.util.Objects;

public class Notificaciones {
    private Integer idNotifcacion;
    private Usuarios IdUsuario;
    private String mensajeNotificacion;
    private Date fechaEnvioNotificacion;
    private Integer estadoNotificacion;
    
    public Notificaciones(){
        
    }

    public Notificaciones(Integer idNotifcacion, Usuarios IdUsuario, String mensajeNotificacion, Date fechaEnvioNotificacion, Integer estadoNotificacion) {
        this.idNotifcacion = idNotifcacion;
        this.IdUsuario = IdUsuario;
        this.mensajeNotificacion = mensajeNotificacion;
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
        this.estadoNotificacion = estadoNotificacion;
    }

    public Integer getIdNotifcacion() {
        return idNotifcacion;
    }

    public void setIdNotifcacion(Integer idNotifcacion) {
        this.idNotifcacion = idNotifcacion;
    }

    public Usuarios getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Usuarios IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getMensajeNotificacion() {
        return mensajeNotificacion;
    }

    public void setMensajeNotificacion(String mensajeNotificacion) {
        this.mensajeNotificacion = mensajeNotificacion;
    }

    public Date getFechaEnvioNotificacion() {
        return fechaEnvioNotificacion;
    }

    public void setFechaEnvioNotificacion(Date fechaEnvioNotificacion) {
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
    }

    public Integer getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(Integer estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idNotifcacion);
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
        final Notificaciones other = (Notificaciones) obj;
        return Objects.equals(this.idNotifcacion, other.idNotifcacion);
    }

    @Override
    public String toString() {
        return "Notificaciones{" + "idNotifcacion=" + idNotifcacion + ", IdUsuario=" + IdUsuario + ", mensajeNotificacion=" + mensajeNotificacion + ", fechaEnvioNotificacion=" + fechaEnvioNotificacion + ", estadoNotificacion=" + estadoNotificacion + '}';
    }
    
}
