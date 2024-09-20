package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Citas;
import edu.jdc.VisionPlus.daos.CitasDAO;
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
public class CitasControlador {

    @Autowired(required = true)
    private CitasDAO citaDao;

    @GetMapping("/listCitas")
    public String listarCita(Model vista) {
        List<Citas> arregloCitas = citaDao.consultar("");
        vista.addAttribute("arrCitas", arregloCitas);
        return "listarCitas";
    }

    @GetMapping("/addCitas")
    public String crearCita(Model vista) {
        vista.addAttribute("objCita", new Citas());
        return "crearCita";
    }

    @PostMapping("/addCitas")
    public String registrarCita(@Valid @ModelAttribute Citas objCita, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearCita";

        } else {
            citaDao.registrar(objCita);
            estado.setComplete();
            return "redirect:/listCitas";
        }
    }

    @GetMapping("/adminCitas")
    public String administrarCita(Model vista) {
        return "administrarCitas";
    }

    @GetMapping("/updateCitas")
    public String actualizarCita(Model vista, Integer llavePrimaria) {
        return "actualizarCita";
    }
}
