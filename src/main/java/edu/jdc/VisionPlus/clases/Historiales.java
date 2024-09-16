package edu.jdc.VisionPlus.clases;

import java.util.Date;
import java.util.Objects;


public class Historiales {
    private Integer idHistorial;
    private Usuarios idPaciente;
    private Usuarios idOftamologo;
    private Date fecha_consulta;
    private String Diagnostico;
    private String Descripcion;
    private String prescripcion;
    
    public Historiales(){
        
    }

    public Historiales(Integer idHistorial, Usuarios idPaciente, Usuarios idOftamologo, Date fecha_consulta, String Diagnostico, String Descripcion, String prescripcion) {
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
