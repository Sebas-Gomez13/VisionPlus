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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/updateNotificaciones/{idNotificacion}")
    public String actualizarNotificacion(Model vista, @PathVariable(value = "idCita") Integer llavePrimaria, RedirectAttributes redireccionar) {
        Notificacion objEncontrado = notificacionDao.buscar(llavePrimaria);
        objEncontrado.setEstadoNotificacion(0);
        notificacionDao.actualizar(objEncontrado);
        return "redirect:/adminNotificaciones";
    }
    
    @GetMapping(value = "/deleteNotificacion/{idNotificacion}")
    public String eliminarNotificacion(@PathVariable(value = "idNotificacion") Integer codSeleccionado, RedirectAttributes redireccionar) {
        boolean elimino = false;
        if (codSeleccionado > 0) {
            elimino = notificacionDao.eliminar(codSeleccionado);
            if (elimino) {
                redireccionar.addFlashAttribute("mensaje", "Notificacion Eliminado");
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar Notificacion");
                redireccionar.addFlashAttribute("tipo", "alert-danger");

            }
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar Tenis");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        }
        return "redirect:/adminNotificaciones";
    }

}
