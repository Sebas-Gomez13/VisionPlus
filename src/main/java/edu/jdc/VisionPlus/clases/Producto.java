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
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "imagen_url")
    private String imagenUrl;
    
    @NotNull
    @Column(name = "categoria")
    private Integer categoria;
    
    @NotNull    
    @Column(name = "cantidad_visitas")
    private Integer cantidadVisitas;
    
    @NotNull    
    @ManyToOne    
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;
    
    public Producto(){
        
    }

    public Producto(Integer idProducto, String nombreProducto, String descripcion, String imagenUrl, Integer categoria, Integer cantidadVisitas, Usuario idUsuario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.categoria = categoria;
        this.cantidadVisitas = cantidadVisitas;
        this.idUsuario = idUsuario;
    }    

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(Integer cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idProducto);
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
        final Producto other = (Producto) obj;
        return Objects.equals(this.idProducto, other.idProducto);
    }

    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion + ", imageenUrl=" + imagenUrl + ", categoria=" + categoria + ", cantidadVisitas=" + cantidadVisitas + ", idUsuario=" + idUsuario + '}';
    }
    
}
