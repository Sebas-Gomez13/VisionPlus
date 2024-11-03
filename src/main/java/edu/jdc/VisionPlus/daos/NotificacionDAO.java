package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.NotificacionRepositorio;

@Service
public class NotificacionDAO implements Operacion<Notificacion>{
    @Autowired(required = true)
    private NotificacionRepositorio repoNotificacion;

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

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        return true;
//        return repoMarca.eliminarMarca(llavePrimaria);
    }

    @Override
    public Integer cantidadRegistros() {
        //         return repoCita.cantidadMarcas();
    return 0;
    }
    
}
