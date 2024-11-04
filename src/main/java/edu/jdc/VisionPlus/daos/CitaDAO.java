package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Rol;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.CitaRepositorio;
import edu.jdc.VisionPlus.repositorios.NotificacionRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CitaDAO implements Operacion<Cita>{
    
    @Autowired
    private CitaRepositorio repoCita;
    @Autowired
    private UsuarioRepositorio repoUsuario;
    @Autowired
    private NotificacionRepositorio repoNotificacion;

    @Override
    public List<Cita> consultar(String orden) {
        return (List<Cita>)repoCita.findAll();
    }

    @Override
    public Boolean registrar(Cita objRegistrar) {
        return repoCita.save(objRegistrar)!=null;
    }

    @Override
    public Cita buscar(Integer llavePrimaria) {
        return repoCita.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Cita objActualizar) {
        return repoCita.save(objActualizar)!=null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
         return true;
    }

    @Override
    public Integer cantidadRegistros() {
        return 0;
    }
    public List<Usuario> obtenerUsuariosPorRol() {
        // Llamar al método definido en el repositorio
        return repoUsuario.findByRolUsuario(new Rol(4, ""));
    }
    
    public List<Usuario> obtenerUsuariosOft() {
        // Llamar al método definido en el repositorio
        return repoUsuario.findByRolUsuario(new Rol(3, ""));
    }
    
    public Boolean nuevaNoti(Notificacion objNoti){
        return repoNotificacion.save(objNoti)!= null;
    }
    
    @Transactional
    public Integer actualizarEstado(Integer llavePrimaria){
        return repoCita.actualizarCita(llavePrimaria);
    }
    
}
