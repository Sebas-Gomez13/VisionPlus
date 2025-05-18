/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Producto;
import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.ProductoRepositorio;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.ReporteRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sebas
 */

@Service
public class ReporteDAO implements Operacion<Reporte>{

    @Autowired
    private ReporteRepositorio repoReporte;       
    
    @Autowired
    private UsuarioRepositorio repoUsuario;
    
    @Autowired
    private ProductoRepositorio repoProducto;
    
    @Override
    public List<Reporte> consultar(String orden) {
        return (List<Reporte>) repoReporte.findAll();
    }

    @Override
    public Boolean registrar(Reporte objRegistrar) {
        return repoReporte.save(objRegistrar)!=null;
    }

    @Override
    public Reporte buscar(Integer llavePrimaria) {
        return repoReporte.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Reporte objActualizar) {
        return repoReporte.save(objActualizar)!=null;
    }

    @Transactional
    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        int eliminado = repoReporte.eliminarReporte(llavePrimaria);
        return eliminado > 0;
    }

    @Override
    public Integer cantidadRegistros() {
        //         return repoCita.cantidadMarcas();
    return 0;
    }    

    public List<Usuario> obtenerUsuarios(){
        return repoUsuario.findByRolUsuarioIn(Arrays.asList(1, 2));
    }   
    
    public List<Producto> obtenerProductos(){
        return (List<Producto>) repoProducto.findAll();
    }
    
}
