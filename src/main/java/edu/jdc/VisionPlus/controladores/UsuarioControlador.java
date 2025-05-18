package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UsuarioControlador {

    @Autowired(required = true)
    private UsuarioDAO usuarioDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/listUsuarios")
    public String listarUsuario(Model vista) {
        List<Usuario> arregloUsuarios = usuarioDao.consultar("");
        vista.addAttribute("arrUsuarios", arregloUsuarios);
        return "administrarUsuarios";
    }

    @GetMapping("/addUsuarios")
    public String crearUsuario(Model vista) {
        vista.addAttribute("objUsuarios", new Usuario());
        return "crearUsuarios";
    }

    @PostMapping("/addUsuarios")
    public String registrarUsuario(@ModelAttribute ("objUsuarios") Usuario objUsuarios, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearUsuarios";
        } else {                      
            objUsuarios.setFechaCreacionUsuario(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            objUsuarios.setEstadoUsuario(1);
            if (objUsuarios.getContrasenaUsuario() != null && !objUsuarios.getContrasenaUsuario().isEmpty()) {
                // Opcional: encriptar contraseña si usas Spring Security
                String encryptedPassword = passwordEncoder.encode(objUsuarios.getContrasenaUsuario());
                objUsuarios.setContrasenaUsuario(encryptedPassword);
            }
            usuarioDao.registrar(objUsuarios);
            int rol = objUsuarios.getRolUsuario();
            if( rol == 4){
                Historial objHistorial = new Historial();            
                objHistorial.setIdPaciente(objUsuarios);
                usuarioDao.nuevoHistorial(objHistorial);
            }            
            estado.setComplete();
            return "redirect:/adminUsuarios";
        }
    }

    @GetMapping("/adminUsuarios")
    public String administrarUsuario(Model vista) {
        List<Usuario> arrUsuarios = usuarioDao.consultar("");
        vista.addAttribute("arrUsuarios", arrUsuarios);
        return "administrarUsuarios";
    }

    @GetMapping(value = "/deleteUsuarios/{idUsuario}")
    public String eliminarUsuario(@PathVariable(value = "idUsuario") Integer codSeleccionado, RedirectAttributes redireccionar) {
        boolean elimino = false;
        if (codSeleccionado > 0) {
            elimino = usuarioDao.eliminar(codSeleccionado);
            if (elimino) {
                redireccionar.addFlashAttribute("mensaje", "Usuario Eliminado");
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar el Usuario");
                redireccionar.addFlashAttribute("tipo", "alert-danger");

            }
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al eliminar Tenis");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        }
        return "redirect:/adminUsuarios";
    }

    @GetMapping(value = {"/updateUsuarios/{idUsuario}"})
    public String actualizarUsuario(Model vista, @PathVariable(value = "idUsuario") Integer llavePrimaria, RedirectAttributes redireccionar) {
        Usuario objEncontrado = usuarioDao.buscar(llavePrimaria);
        if (objEncontrado != null) {
            vista.addAttribute("objUsuario", objEncontrado);
            return "actualizarUsuarios";
        } else {
            redireccionar.addFlashAttribute("mensaje", "Fallo al consultar al Paciente");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
            return "redirect:/adminUsuarios";
        }
    }

    @PostMapping(value = {"/updateUsuarios/{idUsuario}"})
    public String modificarUsuario(@PathVariable(value = "idUsuario") Integer codigo, @ModelAttribute("objUsuario") Usuario objActualizar,
            BindingResult respuesta, SessionStatus estado, RedirectAttributes redireccionar) {                
        if (respuesta.hasErrors()) {
            redireccionar.addFlashAttribute("mensaje", "FallO al Actualizar el Objeto");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
        } else {
            objActualizar.setIdUsuario(codigo);
            if (objActualizar.getContrasenaUsuario() != null && !objActualizar.getContrasenaUsuario().isEmpty()) {
                // Opcional: encriptar contraseña si usas Spring Security
                String encryptedPassword = passwordEncoder.encode(objActualizar.getContrasenaUsuario());
                objActualizar.setContrasenaUsuario(encryptedPassword);
            }
            boolean actualizado = usuarioDao.actualizar(objActualizar);
            if (actualizado) {
                redireccionar.addFlashAttribute("mensaje", "Exito al Actualizar el Usuario: " + objActualizar.getNombreUsuario() + " " + objActualizar.getApellidoUsuario());
                redireccionar.addFlashAttribute("tipo", "alert-success");
            } else {
                redireccionar.addFlashAttribute("mensaje", "Fallo al Actualizar el Objeto");
                redireccionar.addFlashAttribute("tipo", "alert-danger");
            }
        }
        return "redirect:/adminUsuarios";
    }

}
