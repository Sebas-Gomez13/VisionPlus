package edu.jdc.VisionPlus.controladores;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author simulacro
 */
@Controller
public class PaginaControlador {

    @GetMapping("/")
    public String paginaPrincipal(Model vista) {
        return "index";
    }

    @GetMapping("/aboutMe")
    public String paginaAcercaDe(Model vista) {
        return "acercaDe";
    }

    @GetMapping("/contact")
    public String paginaContacto(Model vista) {
        return "contacto";
    }
}
