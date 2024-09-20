package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Notificaciones;
import edu.jdc.VisionPlus.daos.NotificacionesDao;
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
public class NotificacionesControlador {

    @Autowired(required = true)
    private NotificacionesDao notificacionDao;

    @GetMapping("/listBrand")
    public String listarNotificacion(Model vista) {
        List<Notificaciones> arregloNotificaciones = notificacionDao.consultar("");
        vista.addAttribute("arrNotificaciones", arregloNotificaciones);
        return "listarNotificacion";
    }

    @GetMapping("/addBrand")
    public String crearNotificacion(Model vista) {
        vista.addAttribute("objNotificacion", new Notificaciones());
        return "crearNotificacion";
    }

    @PostMapping("/addBrand")
    public String registrarNotificacion(@Valid @ModelAttribute Notificaciones objNotificaciones, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearNotificacion";

        } else {
            notificacionDao.registrar(objNotificaciones);
            estado.setComplete();
            return "redirect:/listBrand";
        }
    }

    @GetMapping("/adminBrand")
    public String administrarNotificacion(Model vista) {
        return "administrarNotificacion";
    }

    @GetMapping("/updateBrand")
    public String actualizarNotificacion(Model vista, Integer llavePrimaria) {
        return "actualizarNotificacion";
    }

}
