package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Citas;
import edu.jdc.VisionPlus.interfaces.Operacion;
import edu.jdc.VisionPlus.repositorios.CitasRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CitasDAO implements Operacion<Citas>{
    
    @Autowired
    private CitasRepositorio repoCita;

    @Override
    public List<Citas> consultar(String orden) {
        return (List<Citas>)repoCita.findAll();
    }

    @Override
    public Boolean registrar(Citas objRegistrar) {
        return repoCita.save(objRegistrar)!=null;
    }

    @Override
    public Citas buscar(Integer llavePrimaria) {
        return repoCita.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Citas objActualizar) {
        return repoCita.save(objActualizar)!=null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
         return true;
//        return repoMarca.eliminarMarca(llavePrimaria);
    }

    @Override
    public Integer cantidadRegistros() {
//         return repoCita.cantidadMarcas();
    return 0;
    }
    
}
