package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.DetalleReporte;
import edu.jdc.VisionPlus.clases.Reporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleReporteRepositorio extends CrudRepository<DetalleReporte, Integer>{
    List<DetalleReporte> findByIdReporte(Reporte idDetalleReporte);
}
