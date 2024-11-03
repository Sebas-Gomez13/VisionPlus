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
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotifcacion;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario IdUsuario;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "mensaje_notificacion")
    private String mensajeNotificacion;
    
    @NotNull    
    @Column(name = "fehca_envio_notificacion")
    private Date fechaEnvioNotificacion;
    
    @NotNull    
    @Column(name = "estado_notificacion")
    private Integer estadoNotificacion;
    
    public Notificacion(){
        
    }

    public Notificacion(Integer idNotifcacion, Usuario IdUsuario, String mensajeNotificacion, Date fechaEnvioNotificacion, Integer estadoNotificacion) {
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

    public Usuario getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Usuario IdUsuario) {
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
        final Notificacion other = (Notificacion) obj;
        return Objects.equals(this.idNotifcacion, other.idNotifcacion);
    }

    @Override
    public String toString() {
        return "Notificaciones{" + "idNotifcacion=" + idNotifcacion + ", IdUsuario=" + IdUsuario + ", mensajeNotificacion=" + mensajeNotificacion + ", fechaEnvioNotificacion=" + fechaEnvioNotificacion + ", estadoNotificacion=" + estadoNotificacion + '}';
    }
    
}
