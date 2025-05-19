package edu.jdc.VisionPlus.repositorios;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Usuario;
import java.util.List;

import jakarta.validation.constraints.NotNull;
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
    long countByEstadoIn(java.util.List<Integer> estados);

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
    @Query(value = """
                    SELECT TO_CHAR(c.fecha_hora, 'FMDay') AS dia_semana,
                       TO_CHAR(c.fecha_hora, 'D') AS dia_orden,
                       COUNT(*) AS total
                FROM citas c
                WHERE c.estado = 1
                  AND c.fecha_hora >= DATE_TRUNC('week', CURRENT_DATE)
                  AND c.fecha_hora < DATE_TRUNC('week', CURRENT_DATE) + INTERVAL '7 days'
                GROUP BY TO_CHAR(c.fecha_hora, 'FMDay'), TO_CHAR(c.fecha_hora, 'D')
                ORDER BY TO_CHAR(c.fecha_hora, 'D')
            """, nativeQuery = true)
    List<Object[]> contarCitasPorDiaSemana();

    @Query("""
    SELECT c.estado, COUNT(c) 
    FROM Cita c 
    WHERE c.estado IN (1, 4) AND c.idOftalmologo.idUsuario = :idOftalmologo 
    GROUP BY c.estado
""")
    List<Object[]> contarCitasPorEstados(@Param("idOftalmologo") Integer idOftalmologo);


}
