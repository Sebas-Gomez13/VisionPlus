/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Reportes;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.ReportesRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sebas
 */
public class ReportesDAO implements Operacion<Reportes>{

    @Autowired
    private ReportesRepositorio repoReporte;
    
    @Override
    public List<Reportes> consultar(String orden) {
        return (List<Reportes>) repoReporte.findAll();
    }

    @Override
    public Boolean registrar(Reportes objRegistrar) {
        return repoReporte.save(objRegistrar)!=null;
    }

    @Override
    public Reportes buscar(Integer llavePrimaria) {
        return repoReporte.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Reportes objActualizar) {
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
