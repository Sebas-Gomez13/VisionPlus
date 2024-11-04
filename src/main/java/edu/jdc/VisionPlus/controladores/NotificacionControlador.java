package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.NotificacionDAO;
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
public class NotificacionControlador {

    @Autowired(required = true)
    private NotificacionDAO notificacionDao;   

    @GetMapping("/addNotificaciones")
    public String crearNotificacion(Model vista) {
        vista.addAttribute("objNotificacion", new Notificacion());
        return "crearNotificacion";
    }

    @PostMapping("/addNotificaciones")
    public String registrarNotificacion(@Valid @ModelAttribute Notificacion objNotificaciones, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearNotificacion";

        } else {
            notificacionDao.registrar(objNotificaciones);
            estado.setComplete();
            return "redirect:/listNotificaciones";
        }
    }

    @GetMapping("/adminNotificaciones")
    public String administrarNotificacion(Model vista) {
        List<Notificacion> arregloNotificaciones = notificacionDao.buscarPaciente();
        vista.addAttribute("arrNotificaciones", arregloNotificaciones);
        return "administrarNotificaciones";
    }

    @GetMapping("/updateNotificaciones")
    public String actualizarNotificacion(Model vista, Integer llavePrimaria) {
        return "actualizarNotificacion";
    }

}
