package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer>{
    
}
