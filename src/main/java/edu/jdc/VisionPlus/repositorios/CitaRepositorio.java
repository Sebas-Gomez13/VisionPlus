package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepositorio extends CrudRepository<Cita, Integer>{
    @Modifying
    @Query("UPDATE Cita set estado=:estadoAct where idCita=:llavePrimaria")
    public Integer actualizarCita(@Param("llavePrimaria") Integer llavePrimaria, @Param("estado") Integer estadoAct);
}
