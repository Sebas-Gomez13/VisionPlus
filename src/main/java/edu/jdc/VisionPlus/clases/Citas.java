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
    @Column(name = "id_Paciente")
    private  Usuarios idPaciente;
    
    @NotNull    
    @Column(name = "id_Oftalmologo")
    private Usuarios idOftamologo;
    
    @NotNull
    @Column(name = "fecha_hora")    
    private Timestamp fecha_hora;
    
    @NotNull
    @Column(name = "estado")    
    private Integer estado;
    
    public Citas(){
        
    }

    public Citas(Integer idCita, Usuarios idPaciente, Usuarios idOftamologo, Timestamp fecha_hora, Integer estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idOftamologo = idOftamologo;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Usuarios getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Usuarios idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Usuarios getIdOftamologo() {
        return idOftamologo;
    }

    public void setIdOftamologo(Usuarios idOftamologo) {
        this.idOftamologo = idOftamologo;
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
        return "Citas{" + "idCita=" + idCita + ", idPaciente=" + idPaciente + ", idOftamologo=" + idOftamologo + ", fecha_hora=" + fecha_hora + ", estado=" + estado + '}';
    }
   
}
