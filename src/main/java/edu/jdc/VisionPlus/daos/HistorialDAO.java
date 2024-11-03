package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.interfaces.Operacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.HistorialRepositorio;

@Service
public class HistorialDAO implements Operacion<Historial>{
    @Autowired
    private HistorialRepositorio repoHistoriales;
    
    @Override
    public List<Historial> consultar(String orden) {
        return (List<Historial>)repoHistoriales.findAll();
    }

    @Override
    public Boolean registrar(Historial objRegistrar) {
        return repoHistoriales.save(objRegistrar)!=null;
    }

    @Override
    public Historial buscar(Integer llavePrimaria) {
        return repoHistoriales.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Historial objActualizar) {
        return repoHistoriales.save(objActualizar)!=null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
                return true;

    }

    @Override
    public Integer cantidadRegistros() {

    return 0;
    }
    
}
