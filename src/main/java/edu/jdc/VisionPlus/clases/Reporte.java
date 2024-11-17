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
import java.util.Objects;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Reporte")
    private Integer idReporte;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nombre_Reporte")
    private String nombreReporte;

    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "descripcion_Reporte")
    private String descripcionReporte;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    public Reporte() {

    }

    public Reporte(Integer idReporte, String nombreReporte, String descripcionReporte, Producto idProducto, Integer cantidad, Usuario idUsuario) {
        this.idReporte = idReporte;
        this.nombreReporte = nombreReporte;
        this.descripcionReporte = descripcionReporte;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.idUsuario = idUsuario;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
        final Reporte other = (Reporte) obj;
        return Objects.equals(this.idReporte, other.idReporte);
    }

    @Override
    public String toString() {
        return "Reporte{" + "idReporte=" + idReporte + ", nombreReporte=" + nombreReporte + ", descripcionReporte=" + descripcionReporte + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", idUsuario=" + idUsuario + '}';
    }

    

}
