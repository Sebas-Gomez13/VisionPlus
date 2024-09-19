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
@Table(name="Roles")
public class Roles {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Rol")
    private Integer idRol;
     
    @NotNull
    @Size(min=3, max=250)
    @Column(name="nombre_Rol")
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
