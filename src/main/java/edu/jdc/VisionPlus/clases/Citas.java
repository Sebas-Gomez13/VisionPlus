package edu.jdc.VisionPlus.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.security.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Cita")
    private Integer idCita;
    
    
    
    @NotNull
    @Column(name = "fecha_hora")    
    private Timestamp fecha_hora;
    
    @NotNull
    @Column(name = "estado")    
    private Integer estado;
    
    public Citas(){
        
    }

    public Citas(Integer idCita,  Timestamp fecha_hora, Integer estado) {
        this.idCita = idCita;
        
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
        final Citas other = (Citas) obj;
        return Objects.equals(this.idCita, other.idCita);
    }

    @Override
    public String toString() {
        return "Citas{" + "idCita=" + idCita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + '}';
    }
   
}
