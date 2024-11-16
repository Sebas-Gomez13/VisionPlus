/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.DetalleHistorial;
import edu.jdc.VisionPlus.clases.DetalleReporte;
import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.daos.DetalleReporteDAO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetalleReporteControlador {
    
    @Autowired
    private DetalleReporteDAO detalleReporteDAO;
    
    @GetMapping("/adminDetalleReporte/{idReporte}")
    public String administrarDetalleReporte(Model vista, @Valid @ModelAttribute Reporte objReporte, @PathVariable(value = "idReporte") Integer llavePrimaria) {
        objReporte.setIdReporte(llavePrimaria);
        List<DetalleReporte> arregloDetalleReporte = detalleReporteDAO.obtenerReporte(objReporte);
        System.out.println(arregloDetalleReporte);
        vista.addAttribute("arrDetalle", arregloDetalleReporte);
        return "administrarDetalleReportes";
    }
    
}
