package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.DetalleHistorial;
import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.DetalleHistorialDAO;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
public class DetalleHistorialControlador {

    @Autowired(required = true)
    private DetalleHistorialDAO detalleHistorialDao;

    @GetMapping("/adminDetalleHistorial/{idHistorial}")
    public String administrarDetalleHistorial(Model vista, @Valid @ModelAttribute Historial objHistorial, @PathVariable(value = "idHistorial") Integer llavePrimaria) {
        objHistorial.setIdHistorial(llavePrimaria);
        List<DetalleHistorial> arregloDetalleHistorial = detalleHistorialDao.obtenerHistorial(objHistorial);
        System.out.println(arregloDetalleHistorial);
        vista.addAttribute("arrDetalle", arregloDetalleHistorial);
        return "administrarDetalleHistorial";
    }

    @GetMapping("/addDetalleHistorial/{idHistorial}")
    public String crearDetalle(Model vista, @PathVariable(value = "idHistorial") Integer llavePrimaria) {
        List<Usuario> arregloDetalleOft = detalleHistorialDao.obtenerUsuariosOft();
        Historial objHistorial = detalleHistorialDao.buscarHistorial(llavePrimaria);
        DetalleHistorial detalle = new DetalleHistorial();
        detalle.setIdHistorial(new Historial(llavePrimaria, null));
        System.out.println(detalle);
        vista.addAttribute("objDetalleHistorial", detalle);
        vista.addAttribute("arrHistorial", objHistorial);
        vista.addAttribute("arrDetalleOf", arregloDetalleOft);
        return "crearDetalleHistorial";
    }

    @PostMapping("/addDetalleHistorial")
    public String registrarUsuario(@Valid @ModelAttribute DetalleHistorial objDetalleHistorial, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearUsuarios";
        } else {
            //Historial historial = detalleHistorialDao.buscarHistorial(objDetalleHistorial.getIdDetalleHistorial()); 
            //System.out.println(historial);
            //objDetalleHistorial.setIdHistorial(historial);
            objDetalleHistorial.setFecha_consulta(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            detalleHistorialDao.registrar(objDetalleHistorial);
            estado.setComplete();
            return "redirect:/adminDetalleHistorial/" + objDetalleHistorial.getIdHistorial().getIdHistorial();
        }
    }

    @GetMapping(value = {"/updateDetalleHistorial/{idDetalleHistorial}"})
    public String actualizarUsuario(Model vista, @PathVariable(value = "idDetalleHistorial") Integer llavePrimaria, RedirectAttributes redireccionar) {
        DetalleHistorial objEncontrado = detalleHistorialDao.buscar(llavePrimaria);
        if (objEncontrado != null) {
            List<Usuario> arregloDetalleOft = detalleHistorialDao.obtenerUsuariosOft();
            vista.addAttribute("arrDetalleOf", arregloDetalleOft);
            vista.addAttribute("objDetalleHistorial", objEncontrado);
            return "actualizarDetalleHistorial";
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al consultar al Paciente");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
            return "redirect:/adminDetalleHistorial/"+objEncontrado.getIdHistorial().getIdHistorial();
        }

    }

    @PostMapping(value = {"/updateDetalleHistorial/{idDetalleHistorial}"})
    public String modificarUsuario(@PathVariable(value = "idDetalleHistorial") Integer codigo, @Valid @ModelAttribute("objDetalleHistorial") DetalleHistorial objActualizar,
            BindingResult respuesta, SessionStatus estado, RedirectAttributes redireccionar) {
        if (respuesta.hasErrors()) {
            redireccionar.addFlashAttribute("mensaje", "FallO al Actualizar el Objeto");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        } else {
            objActualizar.setIdDetalleHistorial(codigo);
            Historial historial = detalleHistorialDao.buscarHistorial(objActualizar.getIdHistorial().getIdHistorial());             
            objActualizar.setIdHistorial(historial);
            objActualizar.setFecha_consulta(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            boolean actualizado = detalleHistorialDao.actualizar(objActualizar);
            if (actualizado) {
                redireccionar.addFlashAttribute("mensaje", "Exito al Actualizar el Historial: "+objActualizar.getIdHistorial().getIdPaciente().getNombreUsuario() + ' ' + objActualizar.getIdHistorial().getIdPaciente().getApellidoUsuario());
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al Actualizar el Objeto");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
            }
        }
        return "redirect:/adminDetalleHistorial/"+objActualizar.getIdHistorial().getIdHistorial();

    }
}