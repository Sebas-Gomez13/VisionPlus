package edu.jdc.VisionPlus.clases;

import java.util.Objects;

public class Roles {

    private Integer idRol;
    private String nombreRol;

    public Roles() {

    }

    public Roles(Integer idRol, String nombreRol) {
        this.idRol=idRol;
        this.nombreRol=nombreRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idRol);
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
        final Roles other = (Roles) obj;
        return Objects.equals(this.idRol, other.idRol);
    }

    @Override
    public String toString() {
        return "Roles{" + "idRol=" + idRol + ", nombreRol=" + nombreRol + '}';
    }
    
    
}
