package edu.jdc.VisionPlus.clases;

import java.util.Objects;

public class Productos {
    private Integer idProducto;
    private String nombreProducto;
    private String descripcion;
    private String imageenUrl;
    private Integer categoria;
    private Integer cantidadVisitas;
    private Usuarios idUsuario;
    
    public Productos(){
        
    }

    public Productos(Integer idProducto, String nombreProducto, String descripcion, String imageenUrl, Integer categoria, Integer cantidadVisitas, Usuarios idUsuario) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imageenUrl = imageenUrl;
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
        return "Productos{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion=" + descripcion + ", imageenUrl=" + imageenUrl + ", categoria=" + categoria + ", cantidadVisitas=" + cantidadVisitas + ", idUsuario=" + idUsuario + '}';
    }
    
}
