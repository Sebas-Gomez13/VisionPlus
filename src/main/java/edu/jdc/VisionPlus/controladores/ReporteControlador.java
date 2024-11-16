package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Producto;
import edu.jdc.VisionPlus.clases.Reporte;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.ReporteDAO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReporteControlador {

    @Autowired(required = true)
    private ReporteDAO reporteDao;

    @GetMapping("/adminReportes")
    public String listarReporte(Model vista) {
        List<Reporte> arregloReportes = reporteDao.consultar("");
        vista.addAttribute("arrReportes", arregloReportes);
        return "administrarReportes";
    }

    @GetMapping("/addReportes")
    public String crearReporte(Model vista) {        
        List<Usuario> arrUsuarios = reporteDao.obtenerUsuarios();
        vista.addAttribute("arrUsuarios", arrUsuarios);
        vista.addAttribute("objReportes", new Reporte());
        return "crearReporte";
    }

    @PostMapping("/addReportes")
    public String registrarReporte(@Valid @ModelAttribute Reporte objReportes, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearReporte";
        } else {
            reporteDao.registrar(objReportes);
            estado.setComplete();
            return "redirect:/adminReportes";
        }
    }
    
    
    @GetMapping(value = "/deleteReportes/{idReporte}")
    public String eliminarUsuario(@PathVariable(value = "idReporte") Integer codSeleccionado, RedirectAttributes redireccionar) {
        boolean elimino = false;
        if (codSeleccionado > 0) {
            elimino = reporteDao.eliminar(codSeleccionado);
            if (elimino) {
                redireccionar.addFlashAttribute("mensaje", "Reporte Eliminado");
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar el Reporte");
                redireccionar.addFlashAttribute("tipo", "alert-danger");

            }
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar el Reporte");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        }
        return "redirect:/adminReportes";
    }
    
    
}
