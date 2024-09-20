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
@Table(name="historiales")
public class Historiales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Historial")
    private Integer idHistorial;
    
    @NotNull
    @Column(name="id_Paciente")
    private Integer idPaciente;
    
    @NotNull
    @Column(name="id_Oftamologo")
    private Integer idOftamologo;
    
    @NotNull
    @Column(name="fecha_Consulta")
    private Date fecha_consulta;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="diagnostico")
    private String Diagnostico;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="descripcion")
    private String Descripcion;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="prescripcion")
    private String prescripcion;
    
    public Historiales(){
        
    }

    public Historiales(Integer idHistorial, Integer idPaciente, Integer idOftamologo, Date fecha_consulta, String Diagnostico, String Descripcion, String prescripcion) {
        this.idHistorial = idHistorial;
        this.idPaciente = idPaciente;
        this.idOftamologo = idOftamologo;
        this.fecha_consulta = fecha_consulta;
        this.Diagnostico = Diagnostico;
        this.Descripcion = Descripcion;
        this.prescripcion = prescripcion;
    }

    

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdOftamologo() {
        return idOftamologo;
    }

    public void setIdOftamologo(Integer idOftamologo) {
        this.idOftamologo = idOftamologo;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
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
        final Historiales other = (Historiales) obj;
        return Objects.equals(this.idHistorial, other.idHistorial);
    }

    @Override
    public String toString() {
        return "Historiales{" + "idHistorial=" + idHistorial + ", idPaciente=" + idPaciente + ", idOftamologo=" + idOftamologo + ", fecha_consulta=" + fecha_consulta + ", Diagnostico=" + Diagnostico + ", Descripcion=" + Descripcion + ", prescripcion=" + prescripcion + '}';
    }
    
}
