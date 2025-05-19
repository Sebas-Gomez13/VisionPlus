package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Historial;
import edu.jdc.VisionPlus.clases.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistorialRepositorio extends CrudRepository<Historial, Integer>{
    public List<Historial> findByIdPaciente(Usuario idPaciente);
}
