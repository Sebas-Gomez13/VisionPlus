package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.daos.ReporteDAO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ReporteControlador {

    @Autowired(required = true)
    private ReporteDAO reporteDao;

    @GetMapping("/listReportes")
    public String listarReporte(Model vista) {
        List<Reporte> arregloReportes = reporteDao.consultar("");
        vista.addAttribute("arrReportes", arregloReportes);
        return "listarReporte";
    }

    @GetMapping("/addReportes")
    public String crearReporte(Model vista) {
        vista.addAttribute("objReporte", new Reporte());
        return "crearReporte";
    }

    @PostMapping("/addReportes")
    public String registrarReporte(@Valid @ModelAttribute Reporte objReportes, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearReporte";

        } else {
            reporteDao.registrar(objReportes);
            estado.setComplete();
            return "redirect:/listReportes";
        }
    }

    @GetMapping("/adminReportes")
    public String administrarReporte(Model vista) {
        return "administrarReporte";
    }

    @GetMapping("/updateReportes")
    public String actualizarReporte(Model vista, Integer llavePrimaria) {
        return "actualizarReporte";
    }
}
