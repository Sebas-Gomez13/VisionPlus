package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Reporte;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReporteRepositorio extends CrudRepository<Reporte, Integer>{
    @Modifying
    @Query("DELETE FROM Reporte WHERE idReporte=:llavePrimaria")
    public Integer eliminarReporte(@Param("llavePrimaria") Integer llavePrimaria);
}
