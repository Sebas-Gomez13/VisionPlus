package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.NotificacionRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificacionDAO implements Operacion<Notificacion>{
    @Autowired(required = true)
    private NotificacionRepositorio repoNotificacion;    
    @Autowired
    private UsuarioRepositorio repoUsuario;

    @Override
    public List<Notificacion> consultar(String orden) {
        return (List<Notificacion>) repoNotificacion.findAll();
    }

    @Override
    public Boolean registrar(Notificacion objRegistrar) {
        return repoNotificacion.save(objRegistrar)!=null;
    }

    @Override
    public Notificacion buscar(Integer llavePrimaria) {
        return repoNotificacion.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Notificacion objActualizar) {
        return repoNotificacion.save(objActualizar)!=null;
    }
    
    @Transactional
    @Override
    public Boolean eliminar(Integer llavePrimaria) {        
        int eliminado = repoNotificacion.eliminarNotificacion(llavePrimaria);
        return eliminado > 0;
    }

    @Override
    public Integer cantidadRegistros() {
        //         return repoCita.cantidadMarcas();
    return 0;
    }
    
    public List<Notificacion> buscarPaciente(){
        return repoNotificacion.findByIdUsuario(new Usuario(2, "", "", "", "", null, "", "", null, null));
    }
    
}
