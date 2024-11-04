package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
import jakarta.validation.Valid;
import java.nio.charset.StandardCharsets;
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
        List<Usuario> arregloCitas = citaDao.obtenerUsuariosPorRol();
        List<Usuario> arregloCitaOft=citaDao.obtenerUsuariosOft();
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
        return "administrarCitas";
    }

    @GetMapping("/updateCitas")
    public String actualizarCita(Model vista, Integer llavePrimaria) {
        return "actualizarCita";
    }
    
    
}
