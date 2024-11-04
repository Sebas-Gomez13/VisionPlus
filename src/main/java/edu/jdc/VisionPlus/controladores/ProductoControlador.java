package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Producto;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.ProductoDAO;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import jakarta.validation.Valid;
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
public class ProductoControlador {

    @Autowired(required = true)
    private ProductoDAO productoDao;
    
     @Autowired
    private UsuarioDAO usuarioDao;

    @GetMapping("/listProducto")
    public String listarProducto(Model vista) {
        List<Producto> arregloProductos = productoDao.consultar("");
        vista.addAttribute("arrProductos", arregloProductos);
        return "listarProducto";
    }

    @GetMapping("/addProducto")
    public String crearProducto(Model vista) {
        List<Usuario> arrUsuarios = productoDao.obtenerUsuarios();
        vista.addAttribute("objProducto", new Producto());
        vista.addAttribute("arrUsuarios", arrUsuarios);
        return "crearProducto";
    }

    @PostMapping("/addProducto")
    public String registrarProducto(@Valid @ModelAttribute Producto objProductos, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearProducto";

        } else {
            objProductos.setCantidadVisitas(0);
            System.out.println(objProductos.getCategoria());
            productoDao.registrar(objProductos);
            estado.setComplete();
            return "redirect:/adminProducto";
        }
    }

    @GetMapping("/adminProducto")
    public String administrarProducto(Model vista) {
        List<Producto> arregloProducto = productoDao.consultar("");
        vista.addAttribute("arrProductos", arregloProducto);
        return "administrarProducto";
    }

    @GetMapping("/updateProducto/{idProducto}")
    public String actualizarProducto(Model vista, @PathVariable(value="idProducto") Integer llavePrimaria,RedirectAttributes redireccionar) {
        Producto objEncontrado = productoDao.buscar(llavePrimaria);
        List<Usuario> arrUsuarios= productoDao.obtenerUsuarios();
        if(objEncontrado!=null){
            vista.addAttribute("objProducto", objEncontrado);
            vista.addAttribute("arrProducto", arrUsuarios);
            return "actualizarProducto";
        }else{
            redireccionar.addFlashAttribute("mensaje", "Fallo al consultar el Producto");
            redireccionar.addFlashAttribute("tipo", "alert-danger");
           return "actualizarProducto"; 
        }
        
    }

}
