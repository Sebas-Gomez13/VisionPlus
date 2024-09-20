package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Notificaciones;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.NotificacionesRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificacionesDao implements Operacion<Notificaciones>{
    
    @Autowired
    private NotificacionesRepositorio repoNotificacion;

    @Override
    public List<Notificaciones> consultar(String orden) {
        return (List<Notificaciones>) repoNotificacion.findAll();
    }

    @Override
    public Boolean registrar(Notificaciones objRegistrar) {
        return repoNotificacion.save(objRegistrar)!=null;
    }

    @Override
    public Notificaciones buscar(Integer llavePrimaria) {
        return repoNotificacion.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Notificaciones objActualizar) {
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
