package edu.jdc.VisionPlus.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="reportes")
public class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Reporte")
    private Integer idReporte;
     
    @NotNull
    @Size(min=3, max=250)
    @Column(name="nombre_Reporte")
    private String nombreReporte;
    
    @NotNull
    @Size(min=3, max=250)
    @Column(name="descripcion_Reporte")
    private String descripcionReporte;
    
    public Reportes(){
        
    }

    public Reportes(Integer idReporte, String nombreReporte, String descripcionReporte) {
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.descripcionReporte = descripcionReporte;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public String getNombreReporte() {
        return nombreReporte;
    }

    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    public String getDescripcionReporte() {
        return descripcionReporte;
    }

    public void setDescripcionReporte(String descripcionReporte) {
        this.descripcionReporte = descripcionReporte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idReporte);
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
        final Reportes other = (Reportes) obj;
        return Objects.equals(this.idReporte, other.idReporte);
    }

    @Override
    public String toString() {
        return "Reportes{" + "idReporte=" + idReporte + ", nombreReporte=" + nombreReporte + ", descripcionReporte=" + descripcionReporte + '}';
    }
    
    
}
