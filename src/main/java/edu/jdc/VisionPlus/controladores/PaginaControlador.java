package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import edu.jdc.VisionPlus.repositorios.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class PaginaControlador {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private CitaDAO citaDAO;

    @Autowired
    private ReporteRepositorio reporteRepo;

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
        Map<String,Long> datos= citaDAO.citasPorDias();
        long cantidadPacientes = usuarioDAO.cantidadPacientes();
        model.addAttribute("cantidadReportes", reporteRepo.count());
        model.addAttribute("cantidadPacientes",cantidadPacientes);
        model.addAttribute("datosCitas",datos);
        model.addAttribute("idUsuario", user);
        return "dashboard/bienvenida";
    }

    @GetMapping("/dashboard")
    public String verDashboard() {
        return "IndexDos";
    }
}
