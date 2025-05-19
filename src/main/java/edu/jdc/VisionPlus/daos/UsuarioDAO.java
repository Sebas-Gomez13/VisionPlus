package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.HistorialRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioDAO implements Operacion<Usuario> {

    @Autowired(required = true)
    private UsuarioRepositorio repoUsuario;

    @Autowired(required = true)
    private HistorialRepositorio repoHistorial;

    @Autowired(required = true)
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> consultar(String orden) {
        return (List<Usuario>) repoUsuario.findAll();
    }

    @Override
    public Boolean registrar(Usuario objRegistrar) {
        return repoUsuario.save(objRegistrar) != null;
    }

    @Override
    public Usuario buscar(Integer llavePrimaria) {
        return repoUsuario.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Usuario objActualizar) {
        return repoUsuario.save(objActualizar) != null;
    }

    @Transactional
    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        int eliminado = repoUsuario.eliminarUsuario(llavePrimaria);
        return eliminado > 0;
    }

    @Override
    public Integer cantidadRegistros() {
        return 0;
    }
    
    public boolean nuevoHistorial(Historial objHistorial){
        return repoHistorial.save(objHistorial) != null;
    }

    public Usuario authenticationUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof Usuario) {
            return (Usuario) principal;
        }

        return null;
    }

    public long cantidadPacientes() {
        return usuarioRepositorio.countByRolUsuario("paciente");
    }

}
