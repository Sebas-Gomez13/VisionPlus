package edu.jdc.VisionPlus.clases;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class UsuarioTest {

    private static Validator validator;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void testValido(){
        Usuario usuario= new Usuario();
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setIdUsuario() {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(null);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("12341234");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        java.util.Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setNombreUsuario() {
        Usuario usuario= new Usuario();
        usuario.setNombreUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setApellidoUsuario() {
        Usuario usuario= new Usuario();
        usuario.setApellidoUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setCorreoUsuario() {
        Usuario usuario= new Usuario();
        usuario.setCorreoUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setContrasenaUsuario() {
        Usuario usuario= new Usuario();
        usuario.setContrasenaUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setFechaCreacionUsuario() {
        Usuario usuario= new Usuario();
        usuario.setFechaCreacionUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setTelefonoUsuario() {
        Usuario usuario= new Usuario();
        usuario.setTelefonoUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setDireccionUsuario() {
        Usuario usuario= new Usuario();
        usuario.setDireccionUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setEstadoUsuario(1);
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setEstadoUsuario() {
        Usuario usuario= new Usuario();
        usuario.setEstadoUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setRolUsuario("Paciente");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setRolUsuario() {
        Usuario usuario= new Usuario();
        usuario.setRolUsuario(null);
        usuario.setIdUsuario(1);
        usuario.setNombreUsuario("Juliana");
        usuario.setApellidoUsuario("Corredor");
        usuario.setCorreoUsuario("juli@gmail.com");
        usuario.setContrasenaUsuario("1234");
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setTelefonoUsuario("3124563456");
        usuario.setDireccionUsuario("Calle 1");
        usuario.setEstadoUsuario(1);
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }
}