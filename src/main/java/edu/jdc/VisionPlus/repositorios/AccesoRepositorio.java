package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoRepositorio extends CrudRepository<Usuario, Integer>{
    @Query("SELECT u.idUsuario, u.nombreUsuario, u.ApellidoUsuario, u.correoUsuario, (SELECT nombreRol FROM Rol where idRol=u.rolUsuario.idRol) FROM Usuario u where u.correoUsuario =:correo AND u.contrasenaUsuario=:clave")
    public List<Object[]> iniciarSesion(@Param("correo") String correoUsuario, @Param("clave") String contrasenaUsuario);
    
}
