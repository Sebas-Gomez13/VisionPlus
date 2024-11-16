/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.ReporteRepositorio;

/**
 *
 * @author sebas
 */

@Service
public class ReporteDAO implements Operacion<Reporte>{

    @Autowired
    private ReporteRepositorio repoReporte;        
    
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
