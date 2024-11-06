package edu.jdc.VisionPlus.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="historiales")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historial")
    private Integer idHistorial;
    
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Usuario idPaciente;
    
    
    
    public Historial(){
        
    }

    public Historial(Integer idHistorial, Usuario idPaciente) {
        this.idHistorial = idHistorial;
        this.idPaciente = idPaciente;
    }


    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Usuario getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Usuario idPaciente) {
        this.idPaciente = idPaciente;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idHistorial);
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
        final Historial other = (Historial) obj;
        return Objects.equals(this.idHistorial, other.idHistorial);
    }

    @Override
    public String toString() {
        return "Historial{" + "idHistorial=" + idHistorial + ", idPaciente=" + idPaciente + '}';
    }

    
}
