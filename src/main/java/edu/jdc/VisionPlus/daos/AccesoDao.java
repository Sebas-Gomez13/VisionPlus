    package edu.jdc.VisionPlus.daos;

import edu.jdc.VisionPlus.clases.DatoSesion;
import edu.jdc.VisionPlus.clases.Rol;
import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.interfaces.Sesion;
import edu.jdc.VisionPlus.repositorios.AccesoRepositorio;
import edu.jdc.VisionPlus.repositorios.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccesoDAO implements Sesion {

    @Autowired(required = true)
    private AccesoRepositorio repoAcceso;
    @Autowired(required = true)
    private UsuarioRepositorio UsuarioRepo;

    @Override
    public DatoSesion inicioDeSesion(Usuario objAcceso) {
        List<Object[]> losDatos = repoAcceso.iniciarSesion(objAcceso.getCorreoUsuario(), objAcceso.getContrasenaUsuario());
        DatoSesion objSesion = null;
        //si los datos no estan vacios
        if (!losDatos.isEmpty()) {
            Object[] datosConsulta = losDatos.get(0);
            objSesion = new DatoSesion();            
            objSesion.setCodUsuario(Integer.valueOf(datosConsulta[0].toString()));
            objSesion.setNombreUsuario(datosConsulta[1].toString());
            objSesion.setApellidosUsuario(datosConsulta[2].toString());
            objSesion.setCorreoAcceso(datosConsulta[3].toString());
            objSesion.setNombreRol(datosConsulta[4].toString());                       
        }
        return objSesion;
    }

//    @Override
//    public DatoSesion registrarNuevoUsuario(Usuario objUsuario, Acceso objAcceso) {    
//        Usuario objRegistro = UsuarioRepo.save(objUsuario);
//    
//        AccesoID accesoID = new AccesoID(objRegistro.getCodUsuario());
//        objAcceso.setAccesoId(accesoID);  // Asigna el AccesoID con el codUsuario del usuario registrado
//    
//        objAcceso.setUsuarioAcceso(objRegistro);  // Asigna el usuario al acceso
//        
//        repoAcceso.save(objAcceso);
//
//        return null;
//}
}
