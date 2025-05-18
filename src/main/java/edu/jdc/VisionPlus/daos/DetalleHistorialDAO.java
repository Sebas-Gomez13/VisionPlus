package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.DetalleHistorial;
import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.DetalleHistorialRepositorio;
import edu.jdc.VisionPlus.repositorios.HistorialRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleHistorialDAO implements Operacion<DetalleHistorial>{

    @Autowired(required = true)
    private DetalleHistorialRepositorio repoDetalleHistorial;
    
    @Autowired
    private UsuarioRepositorio repoUsuario;
    
    @Autowired
    private HistorialRepositorio repoHistorial;
    
    @Override
    public List<DetalleHistorial> consultar(String orden) {
        return null;
    }

    @Override
    public Boolean registrar(DetalleHistorial objRegistrar) {
        return repoDetalleHistorial.save(objRegistrar)!=null;
    }

    @Override
    public DetalleHistorial buscar(Integer llavePrimaria) {
        return repoDetalleHistorial.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(DetalleHistorial objActualizar) {
        return repoDetalleHistorial.save(objActualizar) != null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<DetalleHistorial> obtenerHistorial(Historial objHistorial){
        return repoDetalleHistorial.findByIdHistorial(objHistorial);
    }
    
    public List<Usuario> obtenerUsuariosOft() {
        // Llamar al método definido en el repositorio
        return repoUsuario.findByRolUsuario(3);
    }
    
    public Historial buscarHistorial(Integer llavePrimaria){
        return repoHistorial.findById(llavePrimaria).orElse(null);
    }
}
