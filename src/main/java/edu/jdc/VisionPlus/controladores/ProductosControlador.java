package edu.jdc.VisionPlus.controladores;

import edu.jdc.VisionPlus.clases.Productos;
import edu.jdc.VisionPlus.daos.ProductosDao;
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
public class ProductosControlador {

    @Autowired(required = true)
    private ProductosDao productoDao;

    @GetMapping("/listBrand")
    public String listarProducto(Model vista) {
        List<Productos> arregloProductos = productoDao.consultar("");
        vista.addAttribute("arrProductos", arregloProductos);
        return "listarProducto";
    }

    @GetMapping("/addBrand")
    public String crearProducto(Model vista) {
        vista.addAttribute("objProducto", new Productos());
        return "crearProducto";
    }

    @PostMapping("/addBrand")
    public String registrarProducto(@Valid @ModelAttribute Productos objProductos, BindingResult respuesta, Model vista, SessionStatus estado) {
        if (respuesta.hasErrors()) {
            return "crearProducto";

        } else {
            productoDao.registrar(objProductos);
            estado.setComplete();
            return "redirect:/listBrand";
        }
    }

    @GetMapping("/adminBrand")
    public String administrarProducto(Model vista) {
        return "administrarProducto";
    }

    @GetMapping("/updateBrand")
    public String actualizarProducto(Model vista, Integer llavePrimaria) {
        return "actualizarProducto";
    }

}
