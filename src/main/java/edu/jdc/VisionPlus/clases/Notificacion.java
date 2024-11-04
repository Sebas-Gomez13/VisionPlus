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
    private Integer idNotificacion;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;
    
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

    public Notificacion(Integer idNotificacion, Usuario idUsuario, String mensajeNotificacion, Date fechaEnvioNotificacion, Integer estadoNotificacion) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.mensajeNotificacion = mensajeNotificacion;
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
        this.estadoNotificacion = estadoNotificacion;
    }

    

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idNotificacion);
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
        return Objects.equals(this.idNotificacion, other.idNotificacion);
    }

    @Override
    public String toString() {
        return "Notificacion{" + "idNotificacion=" + idNotificacion + ", idUsuario=" + idUsuario + ", mensajeNotificacion=" + mensajeNotificacion + ", fechaEnvioNotificacion=" + fechaEnvioNotificacion + ", estadoNotificacion=" + estadoNotificacion + '}';
    }

    

    

    
}
