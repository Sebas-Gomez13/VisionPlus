package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Producto;
import edu.jdc.VisionPlus.clases.Rol;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.ProductoRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;

@Service
public class ProductoDAO implements Operacion<Producto>{
    
    @Autowired
    private ProductoRepositorio repoProducto;
    @Autowired
    private UsuarioRepositorio repoUsuario;

    @Override
    public List<Producto> consultar(String orden) {
        return (List<Producto>) repoProducto.findAll();
    }

    @Override
    public Boolean registrar(Producto objRegistrar) {
        return repoProducto.save(objRegistrar)!=null;
    }

    @Override
    public Producto buscar(Integer llavePrimaria) {
        return repoProducto.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Producto objActualizar) {
        return repoProducto.save(objActualizar)!=null;
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
    
    public List<Usuario> obtenerUsuarios(){
        return repoUsuario.findByRolUsuario(new Rol(2,""));
    }
    
}
