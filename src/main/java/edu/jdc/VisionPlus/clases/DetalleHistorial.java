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
@Table(name="detalle_historial")
public class DetalleHistorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalleHistorial")
    private Historial idDetalleHistorial;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_oftalmologo", nullable = false)
    private Usuario idOftamologo;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private Historial idHistorial;
    
    @NotNull
    @Column(name="fecha_consulta")
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

    public DetalleHistorial() {
    }

    public DetalleHistorial(Historial idDetalleHistorial, Usuario idOftamologo, Historial idHistorial, Date fecha_consulta, String Diagnostico, String Descripcion, String prescripcion) {
        this.idDetalleHistorial = idDetalleHistorial;
        this.idOftamologo = idOftamologo;
        this.idHistorial = idHistorial;
        this.fecha_consulta = fecha_consulta;
        this.Diagnostico = Diagnostico;
        this.Descripcion = Descripcion;
        this.prescripcion = prescripcion;
    }

    public Historial getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(Historial idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }


    public Usuario getIdOftamologo() {
        return idOftamologo;
    }

    public void setIdOftamologo(Usuario idOftamologo) {
        this.idOftamologo = idOftamologo;
    }

    public Historial getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Historial idHistorial) {
        this.idHistorial = idHistorial;
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
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idDetalleHistorial);
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
        final DetalleHistorial other = (DetalleHistorial) obj;
        return Objects.equals(this.idDetalleHistorial, other.idDetalleHistorial);
    }

    @Override
    public String toString() {
        return "DetalleHistorial{" + "idDetalleHistorial=" + idDetalleHistorial + ", idOftamologo=" + idOftamologo + ", idHistorial=" + idHistorial + ", fecha_consulta=" + fecha_consulta + ", Diagnostico=" + Diagnostico + ", Descripcion=" + Descripcion + ", prescripcion=" + prescripcion + '}';
    }
    
    
    
}
