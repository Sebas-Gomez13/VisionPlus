package edu.jdc.VisionPlus.clases;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class HistorialTest {

    private static Validator validator;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValido(){
        Usuario paciente = new Usuario();
        Historial historial= new Historial();
        historial.setIdHistorial(1);
        historial.setIdPaciente(paciente);
        Set<ConstraintViolation<Historial>> violations= validator.validate(historial);
        violations.forEach(v -> System.out.println(v.getPropertyPath()+": "+ v.getMessage()));
        assertTrue(violations.isEmpty(),"No deben de haber errores en la validacion");
    }
    @Test
    void setIdHistorial() {
        Usuario paciente = new Usuario();
        Historial historial= new Historial();
        historial.setIdHistorial(null);
        historial.setIdPaciente(paciente);
        Set<ConstraintViolation<Historial>> violations= validator.validate(historial);
        violations.forEach(v -> System.out.println(v.getPropertyPath()+": "+ v.getMessage()));
        assertTrue(violations.isEmpty(),"No deben de haber errores en la validacion");
    }

    @Test
    void setIdPaciente() {
        Usuario paciente = new Usuario();
        Historial historial= new Historial();
        historial.setIdHistorial(1);
        historial.setIdPaciente(null);
        Set<ConstraintViolation<Historial>> violations= validator.validate(historial);
        violations.forEach(v -> System.out.println(v.getPropertyPath()+": "+ v.getMessage()));
        assertTrue(violations.isEmpty(),"No deben de haber errores en la validacion");
    }
}