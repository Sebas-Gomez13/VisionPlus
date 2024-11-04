package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
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
public class CitaControlador {

    @Autowired(required = true)
    private CitaDAO citaDao;

    @GetMapping("/listCitas")
    public String listarCita(Model vista) {
        List<Cita> arregloCitas = citaDao.consultar("");
        vista.addAttribute("arrCitas", arregloCitas);
        return "listarCitas";
    }

    @GetMapping("/addCitas")
    public String crearCita(Model vista) {
        vista.addAttribute("objCita", new Cita());
        return "crearCita";
    }

    @PostMapping("/addCitas")
    public String registrarCita(@Valid @ModelAttribute Cita objCita, BindingResult respuesta, Model vista, SessionStatus estado) {
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
    
    @GetMapping("/usuarios/rol/3")
    public String obtenerUsuariosRol3(Model vista) {
        List<Usuario> arregloCitas = citaDao.obtenerUsuariosPorRol();
        vista.addAttribute("arrCitas", arregloCitas);        
        return "listarCitas";
    }
    
}
