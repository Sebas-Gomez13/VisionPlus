package edu.jdc.VisionPlus.interfaces;

import edu.jdc.VisionPlus.clases.DatoSesion;
import edu.jdc.VisionPlus.clases.Usuario;
import jakarta.servlet.http.HttpSession;

public interface Sesion {
    
    public DatoSesion inicioDeSesion(Usuario objAcceso);        
    
//    public DatoSesion registrarNuevoUsuario(Usuario objUsuario, Acceso objAcceso);
    
}
