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
import java.security.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Usuario idPaciente;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_oftalmologo", nullable = false)
    private Usuario idOftalmologo;
            
    @NotNull
    @Column(name = "fecha_hora")    
    private Timestamp fecha_hora;
    
    @NotNull
    @Column(name = "estado")    
    private Integer estado;
    
    public Cita(){
        
    }

    public Cita(Integer idCita, Usuario idPaciente, Usuario idOftalmologo, Timestamp fecha_hora, Integer estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idOftalmologo = idOftalmologo;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }
    

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    

    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Usuario getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Usuario idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Usuario getIdOftalmologo() {
        return idOftalmologo;
    }

    public void setIdOftalmologo(Usuario idOftalmologo) {
        this.idOftalmologo = idOftalmologo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idCita);
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
        final Cita other = (Cita) obj;
        return Objects.equals(this.idCita, other.idCita);
    }

    @Override
    public String toString() {
        return "Citas{" + "idCita=" + idCita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + '}';
    }
   
}
