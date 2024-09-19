package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Historiales;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.HistorialesRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialesDAO implements Operacion<Historiales>{
    @Autowired
    private HistorialesRepositorio repoHistoriales;
    
    @Override
    public List<Historiales> consultar(String orden) {
        return (List<Historiales>)repoHistoriales.findAll();
    }

    @Override
    public Boolean registrar(Historiales objRegistrar) {
        return repoHistoriales.save(objRegistrar)!=null;
    }

    @Override
    public Historiales buscar(Integer llavePrimaria) {
        return repoHistoriales.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Historiales objActualizar) {
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
