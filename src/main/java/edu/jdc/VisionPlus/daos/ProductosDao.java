package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Productos;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.ProductosRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosDao implements Operacion<Productos>{
    
    @Autowired
    private ProductosRepositorio repoProducto;

    @Override
    public List<Productos> consultar(String orden) {
        return (List<Productos>) repoProducto.findAll();
    }

    @Override
    public Boolean registrar(Productos objRegistrar) {
        return repoProducto.save(objRegistrar)!=null;
    }

    @Override
    public Productos buscar(Integer llavePrimaria) {
        return repoProducto.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Productos objActualizar) {
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
    
}
