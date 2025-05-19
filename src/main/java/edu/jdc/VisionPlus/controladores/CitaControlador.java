package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.CitaDAO;
import edu.jdc.VisionPlus.daos.EmailServiceImpl;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import edu.jdc.VisionPlus.repositorios.CitaRepositorio;
import jakarta.validation.Valid;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
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

    @Autowired(required = true)
    private UsuarioDAO usuarioDao;

    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private CitaRepositorio citaRepositorio;

    @GetMapping("/listCitas")
    public String listarCita(Model vista) {
        List<Cita> arregloCitas;
        Usuario user = usuarioDao.authenticationUser();
        System.out.println(user.getRolUsuario());
        if(user.getRolUsuario().equals("oftalmologo")) {
            arregloCitas = citaRepositorio.findCitaByIdOftalmologo(user);
            System.out.println(arregloCitas);
        } else if (user.getRolUsuario().equals("paciente")) {
            arregloCitas = citaRepositorio.findCitaByIdPaciente(user);
        } else {
            arregloCitas = citaDao.consultar("");
        }
        vista.addAttribute("arrCitas", arregloCitas);
        return "administrarCitas";
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
    public String registrarCita(@ModelAttribute("objCita") Cita objCita, BindingResult respuesta, Model vista, SessionStatus estado) {
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
            Usuario availableOftalmologo = citaDao.getAvailableOftalmologo(null);

            if (availableOftalmologo != null) {
                objCita.setIdOftalmologo(availableOftalmologo);
                objCita.setEstado(1);
            }
            citaDao.registrar(objCita);
            String oftalmologo = "No se le ha asignado un oftalmologo";
            if(objCita.getIdOftalmologo() != null) {
                oftalmologo = objCita.getIdOftalmologo().getNombreUsuario() + " " + objCita.getIdOftalmologo().getNombreUsuario();
            }

            emailService.sendEmail(objCita.getIdPaciente().getCorreoUsuario(), "Nueva Cita Generada", "Informacion Cita: " +
                    "\n Oftalmologo: " + oftalmologo +
                    "\n Fecha y Hora: " + objCita.getFecha_hora());

            estado.setComplete();
            return "redirect:/adminCitas";
        }
    }

    @GetMapping("/adminCitas")
    public String administrarCita(Model vista) {
        List<Cita> arregloCitas;
        Usuario user = usuarioDao.authenticationUser();
        System.out.println(user.getRolUsuario());
        if(user.getRolUsuario().equals("oftalmologo")) {
            arregloCitas = citaRepositorio.findCitaByIdOftalmologo(user);
            System.out.println(arregloCitas);
        } else if (user.getRolUsuario().equals("paciente")) {
            arregloCitas = citaRepositorio.findCitaByIdPaciente(user);
        } else {
            arregloCitas = citaDao.consultar("");
        }
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
    
    
    @PostMapping(value = {"/updateCitas/{idCita}"})
    public String modificarCita(@PathVariable(value = "idCita") Integer codigo, @ModelAttribute("objCitas") Cita objActualizar,
            BindingResult respuesta, SessionStatus estado, RedirectAttributes redireccionar) {                
        if (respuesta.hasErrors()) {
            redireccionar.addFlashAttribute("mensaje", "FallO al Actualizar el Objeto");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        } else {
            objActualizar.setIdCita(codigo); 
            LocalDate fecha = objActualizar.getFecha();
            LocalTime hora = objActualizar.getHora();
            LocalDateTime fechaCitaLocal = LocalDateTime.of(fecha, hora);
            Timestamp fechaCita = Timestamp.valueOf(fechaCitaLocal);
            objActualizar.setFecha_hora(fechaCita);
            emailService.sendEmail(objActualizar.getIdPaciente().getCorreoUsuario(), "Cita Actualizada", "Informacion Cita: " +
                    "\n Oftalmologo: " + objActualizar.getIdOftalmologo().getNombreUsuario() +
                    "\n Fecha y Hora: " + objActualizar.getFecha_hora());
            boolean actualizado = citaDao.actualizar(objActualizar);
            if (actualizado) {
                redireccionar.addFlashAttribute("mensaje", "Exito al Actualizar la Cita de: " + objActualizar.getIdPaciente().getNombreUsuario() + " " + objActualizar.getIdPaciente().getApellidoUsuario());
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al Actualizar el Objeto");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
            }
        }
        return "redirect:/adminCitas";
    }
    
    
    @GetMapping("/nuevaNoti/{idCita}")
    public String nuevaNotificacion(Model vista, @Valid @ModelAttribute Notificacion objNotificacion, @PathVariable(value = "idCita") Integer llavePrimaria, RedirectAttributes redireccionar){
        Cita objEncontrado = citaDao.buscar(llavePrimaria);
        LocalDate fecha = objEncontrado.getFecha_hora().toLocalDateTime().toLocalDate();            
        LocalTime hora = objEncontrado.getFecha_hora().toLocalDateTime().toLocalTime();             
        String mensaje = "Recuerde que el dia: " + fecha + " a las: " + hora + " usted tiene programada una cita oftalmologica";         
        objNotificacion.setIdUsuario(objEncontrado.getIdPaciente());
        objNotificacion.setMensajeNotificacion(mensaje);
        objNotificacion.setEstadoNotificacion(1);
        objNotificacion.setFechaEnvioNotificacion(Date.from(Instant.now()));
        emailService.sendEmail(objNotificacion.getIdUsuario().getCorreoUsuario(), "Recordatorio Cita", "Recuerde que el dia de hoy tiene una cita");
        boolean noti = citaDao.nuevaNoti(objNotificacion);
        if(noti){
            Integer actu = citaDao.actualizarEstado(objEncontrado.getIdCita(), 2);
            if(actu > 0){
                redireccionar.addFlashAttribute("mensaje", "Notificacion Enviada Correctamente");
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al Enviar la Notificacion");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
            }
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al Enviar la Notificacion");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
        }    
        return "redirect:/adminCitas";
    }
    
    @GetMapping(value = "/deleteCitas/{idCita}")
    public String eliminarCita(@PathVariable(value = "idCita") Integer codSeleccionado, RedirectAttributes redireccionar) {
        boolean elimino = false;
        if (codSeleccionado > 0) {
            elimino = citaDao.eliminar(codSeleccionado);
            if (elimino) {
                redireccionar.addFlashAttribute("mensaje", "Cita Cancelada");
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al Cancelar la Cita");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
            }
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al Cancelar la Cita");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        }
        return "redirect:/adminCitas";
    }
    
    @GetMapping(value = "/confirmarCita/{idCita}")
    public String terminarCita(Model vista, @PathVariable(value = "idCita") Integer llavePrimaria, RedirectAttributes redireccionar) {
        Cita objEncontrado = citaDao.buscar(llavePrimaria);
        citaDao.actualizarEstado(objEncontrado.getIdCita(), 3);
        return "redirect:/adminCitas";
    }

    @PostMapping("AssignOftalmologo/{id}")
    public String assignOftalmologo(@PathVariable Integer id) {
        Cita citaEntity = citaDao.buscar(id);

        Integer previousState = citaEntity.getEstado();

        // Validación: si ya tiene técnico asignado, redirige sin hacer nada
        if (citaEntity.getIdOftalmologo() != null) {
            return "redirect:/ListCita";
        }

        Usuario availableOftalmologo = citaDao.getAvailableOftalmologo(citaEntity.getIdOftalmologo().getIdUsuario());
        Usuario user = usuarioDao.buscar(citaEntity.getIdPaciente().getIdUsuario());

        if (availableOftalmologo != null) {
            citaEntity.setIdOftalmologo(availableOftalmologo);
            citaEntity.setEstado(1);
        }
        Cita updateCitaEntity = citaRepositorio.save(citaEntity);
        Integer newState = updateCitaEntity.getEstado();
        Usuario idUser = usuarioDao.authenticationUser();

        if (updateCitaEntity.getIdOftalmologo() != null) {
            emailService.sendEmail(updateCitaEntity.getIdPaciente().getCorreoUsuario(), "Cita Actualizada", "La cita del dia: " + updateCitaEntity.getFecha_hora() + " ha sido actualizada" +
                    "\n Notificacion: " + "La cita Fue Asignada a un Oftalmologo");
            emailService.sendEmail(updateCitaEntity.getIdOftalmologo().getCorreoUsuario(), "Nueva Cita", "Se le ha Asignado la Cita" +
                    "\n Notificacion: " + "Se le ha Asignado una Nueva Cita");
        }

        return "redirect:/ListCita";
    }


}
