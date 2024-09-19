package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Usuarios;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosDAOS implements Operacion<Usuarios> {

    @Autowired
    private UsuarioRepositorio repoUsuario;

    @Override
    public List<Usuarios> consultar(String orden) {
        return (List<Usuarios>) repoUsuario.findAll();
    }

    @Override
    public Boolean registrar(Usuarios objRegistrar) {
        return repoUsuario.save(objRegistrar) != null;
    }

    @Override
    public Usuarios buscar(Integer llavePrimaria) {
        return repoUsuario.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Usuarios objActualizar) {
        return repoUsuario.save(objActualizar) != null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        return true;

    }

    @Override
    public Integer cantidadRegistros() {

        return 0;
    }

}
