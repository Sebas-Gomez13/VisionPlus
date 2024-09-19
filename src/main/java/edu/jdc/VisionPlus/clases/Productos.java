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
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Producto")
    private Integer idProducto;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "nombre_Producto")
    private String nombreProducto;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    
    @NotNull
    @Size(min = 3, max = 250)
    @Column(name = "imagen_Url")
    private String imagenUrl;
    
    @NotNull
    @Column(name = "categoria")
    private Integer categoria;
    
    @NotNull    
    @Column(name = "cantida_dVisitas")
    private Integer cantidadVisitas;
    
    @NotNull    
    @Column(name = "id_Usuario")
    private Usuarios idUsuario;
    
    public Productos(){
        
    }

    public Productos(Integer idProducto, String nombreProducto, String descripcion, String imageenUrl, Integer categoria, Integer cantidadVisitas, Usuarios idUsuario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenUrl = imageenUrl;
        this.categoria = categoria;
        this.cantidadVisitas = cantidadVisitas;
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
        final Productos other = (Productos) obj;
        return Objects.equals(this.idProducto, other.idProducto);
    }

    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion + ", imageenUrl=" + imagenUrl + ", categoria=" + categoria + ", cantidadVisitas=" + cantidadVisitas + ", idUsuario=" + idUsuario + '}';
    }
    
}
