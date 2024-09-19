package edu.jdc.VisionPlus.clases;

import java.util.Objects;

public class Reportes {
    private Integer idReporte;
    private String nombreReporte;
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
