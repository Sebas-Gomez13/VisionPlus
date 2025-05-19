package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepositorio extends CrudRepository<Cita, Integer>{
    @Modifying
    @Query("UPDATE Cita set estado=:estadoAct where idCita=:llavePrimaria")
    public Integer actualizarCita(@Param("llavePrimaria") Integer llavePrimaria, @Param("estadoAct") Integer estadoAct);
    public List<Cita> findCitaByIdOftalmologo(Usuario oft);
    public List<Cita> findCitaByIdPaciente(Usuario user);
    int countByIdOftalmologoAndEstado(Usuario oftalmologo, Integer estado);
    @Query("""
                SELECT c FROM Cita c
                WHERE c.idOftalmologo.idUsuario = :idOftalmologo
                AND (:estado IS NULL OR c.estado = :estado)
            """)
    List<Cita> findCitasFiltrados(
            @Param("idOftalmologo") Long idOftalmologo,
            @Param("estado") Integer estado
    );
}
