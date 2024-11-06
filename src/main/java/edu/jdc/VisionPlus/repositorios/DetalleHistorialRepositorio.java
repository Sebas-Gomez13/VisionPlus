package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.DetalleHistorial;
import edu.jdc.VisionPlus.clases.Historial;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleHistorialRepositorio extends CrudRepository <DetalleHistorial,Integer>{
     List<DetalleHistorial> findByIdHistorial(Historial idDetalleHistorial);
}
