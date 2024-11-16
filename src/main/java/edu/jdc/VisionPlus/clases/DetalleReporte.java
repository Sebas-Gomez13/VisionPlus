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
import java.util.Objects;

@Entity
@Table(name="detalle_reporte")
public class DetalleReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalleReporte")
    private Integer idDetalleReporte;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_reporte", nullable = false)
    private Reporte idReporte;
    
    @NotNull    
    @Column(name = "nombreProducto")
    private String nombreProducto;

    @NotNull
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public DetalleReporte() {
    }

    public DetalleReporte(Integer idDetalleReporte, Reporte idReporte, String nombreProducto, Integer cantidad) {
        this.idDetalleReporte = idDetalleReporte;
        this.idReporte = idReporte;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleReporte() {
        return idDetalleReporte;
    }

    public void setIdDetalleReporte(Integer idDetalleReporte) {
        this.idDetalleReporte = idDetalleReporte;
    }

    public Reporte getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Reporte idReporte) {
        this.idReporte = idReporte;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.idDetalleReporte);
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
        final DetalleReporte other = (DetalleReporte) obj;
        return Objects.equals(this.idDetalleReporte, other.idDetalleReporte);
    }

    @Override
    public String toString() {
        return "DetalleReporte{" + "idDetalleReporte=" + idDetalleReporte + ", idReporte=" + idReporte + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + '}';
    }
    
    
}
