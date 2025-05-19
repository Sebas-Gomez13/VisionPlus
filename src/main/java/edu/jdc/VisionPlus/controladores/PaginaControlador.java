package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaginaControlador {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @GetMapping("/")
    public String paginaPrincipal(Model vista) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model vista) {
        return "inicioSesion";
    }

    @GetMapping("/aboutMe")
    public String paginaAcercaDe(Model vista) {
        return "acercaDe";
    }

    @GetMapping("/contact")
    public String paginaContacto(Model vista) {
        return "contacto";
    }

    @GetMapping("/bienvenida")
    public String paginaBienvenia(Model model) {
        Usuario user = usuarioDAO.authenticationUser();
        System.out.println(user.toString());
        model.addAttribute("idUsuario", user);
        return "dashboard/bienvenida";
    }

    @GetMapping("/dashboard")
    public String verDashboard() {
        return "IndexDos"; // <== Usa la ruta relativa dentro de templates (sin .html)
    }
}
