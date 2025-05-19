package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import edu.jdc.VisionPlus.repositorios.CitaRepositorio;
import edu.jdc.VisionPlus.repositorios.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;


@Controller
public class PaginaControlador {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private CitaDAO citaDAO;

    @Autowired
    private ReporteRepositorio reporteRepo;

    @Autowired
    private CitaRepositorio citaRepo;

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
        if(user.getRolUsuario().equals("oftalmologo")){
            Map<Integer, Long> conteoCitas = citaDAO.totalCitasPorEstado(user.getIdUsuario());

            // Extraer valores para el gráfico
            Long estado1 = conteoCitas.getOrDefault(1, 0L);
            Long estado4 = conteoCitas.getOrDefault(4, 0L);

            model.addAttribute("estado1", estado1);
            model.addAttribute("estado4", estado4);
        }
        model.addAttribute("cantidadReportes", reporteRepo.count());
        model.addAttribute("cantidadPacientes",cantidadPacientes);
        model.addAttribute("cantidadPendientes", citaRepo.countByEstadoIn(Arrays.asList(1, 2)));
        model.addAttribute("datosCitas",datos);
        model.addAttribute("idUsuario", user);
        return "dashboard/bienvenida";
    }


}
