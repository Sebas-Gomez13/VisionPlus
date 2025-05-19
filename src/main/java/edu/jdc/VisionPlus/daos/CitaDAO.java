package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.Cita;
import edu.jdc.VisionPlus.clases.Notificacion;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Operacion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.jdc.VisionPlus.repositorios.CitaRepositorio;
import edu.jdc.VisionPlus.repositorios.NotificacionRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CitaDAO implements Operacion<Cita>{
    
    @Autowired
    private CitaRepositorio repoCita;
    @Autowired
    private UsuarioRepositorio repoUsuario;
    @Autowired
    private NotificacionRepositorio repoNotificacion;
    @Autowired
    private CitaRepositorio citaRepositorio;

    @Override
    public List<Cita> consultar(String orden) {
        return (List<Cita>)repoCita.findAll();
    }

    @Override
    public Boolean registrar(Cita objRegistrar) {
        return repoCita.save(objRegistrar)!=null;
    }

    @Override
    public Cita buscar(Integer llavePrimaria) {
        return repoCita.findById(llavePrimaria).orElse(null);
    }

    @Override
    public Boolean actualizar(Cita objActualizar) {
        return repoCita.save(objActualizar)!=null;
    }

    @Transactional
    @Override
    public Boolean eliminar(Integer llavePrimaria) {
         int eliminado = repoCita.actualizarCita(llavePrimaria, 4);
         return eliminado > 0;
    }

    @Override
    public Integer cantidadRegistros() {
        return 0;
    }
    public List<Usuario> obtenerUsuariosPorRol() {
        // Llamar al método definido en el repositorio
        return repoUsuario.findByRolUsuario("paciente");
    }
    
    public List<Usuario> obtenerUsuariosOft() {
        // Llamar al método definido en el repositorio
        return repoUsuario.findByRolUsuario("oftalmologo");
    }
    
    public Boolean nuevaNoti(Notificacion objNoti){
        return repoNotificacion.save(objNoti)!= null;
    }
    
    @Transactional
    public Integer actualizarEstado(Integer llavePrimaria, Integer estadoAct){
        return repoCita.actualizarCita(llavePrimaria, estadoAct);
    }


    public Usuario getAvailableOftalmologo(Integer idActualOftalmologo) {
        List<Usuario> oftalmologos = repoUsuario.findByRolUsuario("oftalmologo");
        int maxOpenCitas = 2;

        for (Usuario oftalmologo : oftalmologos) {
            if (idActualOftalmologo != null && oftalmologo.getIdUsuario().equals(idActualOftalmologo)) {
                continue;
            }

            int open = repoCita.countByIdOftalmologoAndEstado(oftalmologo, 1);
            if (open < maxOpenCitas) {
                return oftalmologo;
            }
        }
        return null;
    }

    //Metodo para graficas
    public Map<String,Long> citasPorDias(){
        List<Object[]> resultados = citaRepositorio.contarCitasPorDiaSemana();
        Map<String, Long> conteo = new LinkedHashMap<>();
        for(Object[] fila : resultados) {
            String diaSemana = (String) fila[0];
            Integer diaOrden = Integer.parseInt((String) fila[1]);
            Long total = ((Number) fila[2]).longValue();
            conteo.put(diaSemana, total);
        }
        return conteo;
    }

    public Map<Integer, Long> totalCitasPorEstado(Integer idOftalmologo) {
        List<Object[]> resultados = citaRepositorio.contarCitasPorEstados(idOftalmologo);
        Map<Integer, Long> conteo = new HashMap<>();

        for (Object[] fila : resultados) {
            Integer estado = (Integer) fila[0];
            Long total = ((Number) fila[1]).longValue();
            conteo.put(estado, total);
        }

        return conteo;
    }



}
