package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.HistorialRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioDAO implements Operacion<Usuario> {

    @Autowired(required = true)
    private UsuarioRepositorio repoUsuario;

    @Autowired(required = true)
    private HistorialRepositorio repoHistorial;

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

}
