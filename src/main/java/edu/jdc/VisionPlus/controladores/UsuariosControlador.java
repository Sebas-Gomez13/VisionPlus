package edu.jdc.VisionPlus.controladores;


import edu.jdc.VisionPlus.clases.Usuarios;
import edu.jdc.VisionPlus.daos.UsuariosDAO;
import jakarta.validation.Valid;
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
public class UsuariosControlador {

    @Autowired(required = true)
    private UsuariosDAO usuarioDao;

    @GetMapping("/listBrand")
    public String listarUsuario(Model vista) {
        List<Usuarios> arregloUsuarios = usuarioDao.consultar("");
        vista.addAttribute("arrUsuarios", arregloUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/addBrand")
    public String crearUsuario(Model vista) {
        vista.addAttribute("objUsuario", new Usuarios());
        return "crearUsuario";
    }

    @PostMapping("/addBrand")
    public String registrarUsuario(@Valid @ModelAttribute Usuarios objUsuarios, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearUsuario";

        } else {
            usuarioDao.registrar(objUsuarios);
            estado.setComplete();
            return "redirect:/listBrand";
        }
    }

    @GetMapping("/adminBrand")
    public String administrarUsuario(Model vista) {
        return "administrarUsuario";
    }

    @GetMapping("/updateBrand")
    public String actualizarUsuario(Model vista, Integer llavePrimaria) {
        return "actualizarUsuario";
    }

}
