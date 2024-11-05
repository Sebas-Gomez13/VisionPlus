package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.DatoSesion;
import edu.jdc.VisionPlus.clases.Rol;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.AccesoDao;
import jakarta.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccesoControlador {

    @Autowired(required = true)
    private AccesoDao daoAcceso;

    @GetMapping("/signin")
    public String iniciarSesion(Model vista) {
        vista.addAttribute("objAcceso", new Usuario());
        return "inicioSesion";
    }

    @PostMapping("/signin")
    public String sesion(@Valid @ModelAttribute("objAcceso") Usuario objAcceso, BindingResult respuesta, Model vista, SessionStatus estado, RedirectAttributes redireccionar) {
        if (respuesta.hasErrors()) {
            vista.addAttribute("mensaje", "Error en ingreso de los datos");
            vista.addAttribute("tipo", "alert-danger");
            return "inicioSesion";
        } else {
            String ClaveCifrada = DigestUtils.sha512Hex(objAcceso.getContrasenaUsuario());
            objAcceso.setContrasenaUsuario(ClaveCifrada);
            DatoSesion objSesion = daoAcceso.inicioDeSesion(objAcceso);
            if (objSesion != null) {
                System.out.println(objSesion.toString());
                estado.isComplete();
                redireccionar.addFlashAttribute("objSesion", objSesion);
                return "redirect:/dashboard";

            } else {
                vista.addAttribute("mensaje", "Fallo al iniciar sesion verifique credenciales");
                vista.addAttribute("tipo", "alert-danger");
                return "inicioSesion";
            }
        }
    }
    
    @GetMapping("/cerrarSesion")
    public String cerrarSesion(SessionStatus estado) {
        // Completar el estado de la sesión
        estado.setComplete(); // Esto marcará la sesión como completa y la eliminará

        return "redirect:/signin"; // Redirigir al login
    }

    @GetMapping("/dashboard")
    public String bienvenida(Model vista) {
        return "dashboard/bienvenida";
    }
    
//    @GetMapping("/register")
//    public String nuevoUsuario(Model vista) {
//        vista.addAttribute("objAcceso", new Acceso());
//        return "crearUsuario";
//    }
    
//    @PostMapping("/register")
//    public String registrarUsuario(@Valid @ModelAttribute Acceso objAcceso, BindingResult respuesta, Model vista, SessionStatus estado) throws ParseException {
//        if (respuesta.hasErrors()) {
//            return "crearUsuario";
//        } else {
//            String fechaTexto = "31-10-2024";
//            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); 
//            Date fecha = formatoFecha.parse(fechaTexto);
//            Usuario nuevoUsuario=objAcceso.getUsuarioAcceso();
//            nuevoUsuario.setRolUsuario(new Rol(1, "", Short.valueOf("1")));
//            nuevoUsuario.setFechaNacimientoUsuario(fecha);                                    
//            daoAcceso.registrarNuevoUsuario(nuevoUsuario, objAcceso);
//            estado.setComplete();
//            return "redirect:/signin";
//        }
//    }

}
