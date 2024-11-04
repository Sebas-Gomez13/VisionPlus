package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotificacionRepositorio extends CrudRepository<Notificacion, Integer>{
    List<Notificacion> findByIdUsuario(Usuario IdUsuario);
    
    @Modifying
    @Query("DELETE FROM Notificacion WHERE idNotificacion=:llavePrimaria")
    public Integer eliminarNotificacion(@Param("llavePrimaria") Integer llavePrimaria);        
}
