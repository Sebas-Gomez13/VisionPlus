package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.DetalleHistorial;
import edu.jdc.VisionPlus.clases.DetalleReporte;
import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.DetalleReporteRepositorio;
import edu.jdc.VisionPlus.repositorios.ReporteRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleReporteDAO implements Operacion<DetalleReporte>{
    
    @Autowired
    private DetalleReporteRepositorio repoDetalleReporte;
    
    @Autowired
    private ReporteRepositorio repoReporte;

    @Override
    public List<DetalleReporte> consultar(String orden) {
        return (List<DetalleReporte>) repoDetalleReporte.findAll();
    }

    @Override
    public Boolean registrar(DetalleReporte objRegistrar) {
        return repoDetalleReporte.save(objRegistrar)!=null;
    }

    @Override
    public DetalleReporte buscar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(DetalleReporte objActualizar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<DetalleReporte> obtenerReporte(Reporte objReporte){
        return repoDetalleReporte.findByIdReporte(objReporte);
    }
    
}
