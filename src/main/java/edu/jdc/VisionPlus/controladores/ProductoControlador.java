package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Producto;
import edu.jdc.VisionPlus.daos.ProductoDAO;
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
public class ProductoControlador {

    @Autowired(required = true)
    private ProductoDAO productoDao;

    @GetMapping("/listProducto")
    public String listarProducto(Model vista) {
        List<Producto> arregloProductos = productoDao.consultar("");
        vista.addAttribute("arrProductos", arregloProductos);
        return "listarProducto";
    }

    @GetMapping("/addProducto")
    public String crearProducto(Model vista) {
        vista.addAttribute("objProducto", new Producto());
        return "crearProducto";
    }

    @PostMapping("/addProducto")
    public String registrarProducto(@Valid @ModelAttribute Producto objProductos, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearProducto";

        } else {
            productoDao.registrar(objProductos);
            estado.setComplete();
            return "redirect:/listProducto";
        }
    }

    @GetMapping("/adminProducto")
    public String administrarProducto(Model vista) {
        return "administrarProducto";
    }

    @GetMapping("/updateProducto")
    public String actualizarProducto(Model vista, Integer llavePrimaria) {
        return "actualizarProducto";
    }

}
