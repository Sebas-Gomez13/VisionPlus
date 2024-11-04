package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NotificacionRepositorio extends CrudRepository<Notificacion, Integer>{
    List<Notificacion> findByIdUsuario(Usuario IdUsuario);
}
