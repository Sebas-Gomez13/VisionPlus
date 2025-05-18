package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    @Modifying
    @Query("UPDATE Usuario set estadoUsuario=0 WHERE idUsuario=:llavePrimaria")
    public Integer eliminarUsuario(@Param("llavePrimaria") Integer llavePrimaria);

    List<Usuario> findByRolUsuario(Integer rolUsuario);
    Usuario findByCorreoUsuario(String correo);
        
    List<Usuario> findByRolUsuarioIn(List<Integer> ids);

}
