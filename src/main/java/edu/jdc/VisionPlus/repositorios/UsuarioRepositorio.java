package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuarios, Integer>{
    
}
