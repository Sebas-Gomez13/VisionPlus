package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import jakarta.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class CitaControlador {

    @Autowired(required = true)
    private CitaDAO citaDao;

    @Autowired
    private UsuarioDAO usuarioDao;

    @GetMapping("/listCitas")
    public String listarCita(Model vista) {
        List<Cita> arregloCitas = citaDao.consultar("");
        vista.addAttribute("arrCitas", arregloCitas);
        return "listarCitas";
    }

    @GetMapping("/addCitas")
    public String crearCita(Model vista) {
        List<Usuario> arregloCitas = citaDao.obtenerUsuariosPorRol();
        List<Usuario> arregloCitaOft = citaDao.obtenerUsuariosOft();
        vista.addAttribute("objCita", new Cita());
        vista.addAttribute("arrCita", arregloCitas);
        vista.addAttribute("arrCitaOf", arregloCitaOft);
        return "crearCita";
    }

    @PostMapping("/addCitas")
    public String registrarCita(@Valid @ModelAttribute Cita objCita, BindingResult respuesta, Model vista, SessionStatus estado) {
        System.out.println(objCita.getFecha());
        System.out.println(objCita.getHora());
        if (respuesta.hasErrors()) {
            return "crearCita";
        } else {
            LocalDate fecha = objCita.getFecha();
            LocalTime hora = objCita.getHora();
            LocalDateTime fechaCitaLocal = LocalDateTime.of(fecha, hora);
            Timestamp fechaCita = Timestamp.valueOf(fechaCitaLocal);
            objCita.setFecha_hora(fechaCita);
            objCita.setEstado(1);

            citaDao.registrar(objCita);
            estado.setComplete();
            return "redirect:/listCitas";
        }
    }

    @GetMapping("/adminCitas")
    public String administrarCita(Model vista) {
        List<Cita> arregloCitas = citaDao.consultar("");
        vista.addAttribute("arrCitas", arregloCitas);
        return "administrarCitas";
    }

    @GetMapping("/updateCitas/{idCita}")
    public String actualizarCita(Model vista, @PathVariable(value = "idCita") Integer llavePrimaria, RedirectAttributes redireccionar) {
        Cita objEncontrado = citaDao.buscar(llavePrimaria);
        List<Usuario> arrPacientes = citaDao.obtenerUsuariosPorRol();
        List<Usuario> arrOftalmologo = citaDao.obtenerUsuariosOft();
        if (objEncontrado != null) {
            LocalDate fecha = objEncontrado.getFecha_hora().toLocalDateTime().toLocalDate();            
            LocalTime hora = objEncontrado.getFecha_hora().toLocalDateTime().toLocalTime();            
            objEncontrado.setFecha(fecha);
            objEncontrado.setHora(hora);
            vista.addAttribute("objCitas", objEncontrado);
            vista.addAttribute("arrCita", arrPacientes);
            vista.addAttribute("arrCitaOf", arrOftalmologo);
            return "actualizarCitas";
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al consultar al Paciente");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
            return "redirect:/adminCitas";
        }
    }

}
