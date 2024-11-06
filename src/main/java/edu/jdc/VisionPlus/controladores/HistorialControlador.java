package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.daos.HistorialDAO;
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
public class HistorialControlador {

    @Autowired(required = true)
    private HistorialDAO historialDao;

    @GetMapping("/adminHistoriales")
    public String administrarHistorial(Model vista) {
        List<Historial> arregloHistoriales = historialDao.consultar("");
        vista.addAttribute("arrHistoriales", arregloHistoriales);
        return "administrarHistoriales";
    }

    @GetMapping("/addHistoriales")
    public String crearHistorial(Model vista) {
        vista.addAttribute("objHistorial", new Historial());
        return "crearHistorial";
    }

    @PostMapping("/addHistoriales")
    public String registrarHistorial(@Valid @ModelAttribute Historial objHistorial, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearHistorial";

        } else {
            historialDao.registrar(objHistorial);
            estado.setComplete();
            return "redirect:/listHistoriales";
        }
    }
    

    @GetMapping("/updateHistoriales")
    public String actualizarHistorial(Model vista, Integer llavePrimaria) {
        return "actualizarHistorial";
    }

}
