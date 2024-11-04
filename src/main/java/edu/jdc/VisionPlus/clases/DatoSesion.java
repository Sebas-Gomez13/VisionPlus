package edu.jdc.VisionPlus.clases;

public class DatoSesion {
    
    private Integer codUsuario;
    private String nombreUsuario;
    private String apellidosUsuario;
    private String correoAcceso;
    private String nombreRol;

    public DatoSesion() {
    }

    public DatoSesion(Integer codUsuario, String nombreUsuario, String apellidosUsuario, String correoAcceso, String nombreRol) {
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.correoAcceso = correoAcceso;
        this.nombreRol = nombreRol;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getCorreoAcceso() {
        return correoAcceso;
    }

    public void setCorreoAcceso(String correoAcceso) {
        this.correoAcceso = correoAcceso;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "DatoSesion{" + "codUsuario=" + codUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidosUsuario=" + apellidosUsuario + ", correoAcceso=" + correoAcceso + ", nombreRol=" + nombreRol + '}';
    }
    
    
    
}
