package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Historiales;
import edu.jdc.VisionPlus.daos.HistorialesDAO;
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
public class HistorialesControlador {

    @Autowired(required = true)
    private HistorialesDAO historialDao;

    @GetMapping("/listBrand")
    public String listarHistorial(Model vista) {
        List<Historiales> arregloHistoriales = historialDao.consultar("");
        vista.addAttribute("arrHistoriales", arregloHistoriales);
        return "listarHistoriales";
    }

    @GetMapping("/addBrand")
    public String crearHistorial(Model vista) {
        vista.addAttribute("objHistorial", new Historiales());
        return "crearHistorial";
    }

    @PostMapping("/addBrand")
    public String registrarHistorial(@Valid @ModelAttribute Historiales objHistorial, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearHistorial";

        } else {
            historialDao.registrar(objHistorial);
            estado.setComplete();
            return "redirect:/listBrand";
        }
    }

    @GetMapping("/adminBrand")
    public String administrarHistorial(Model vista) {
        return "administrarHistorial";
    }

    @GetMapping("/updateBrand")
    public String actualizarHistorial(Model vista, Integer llavePrimaria) {
        return "actualizarHistorial";
    }

}
