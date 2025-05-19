package edu.jdc.VisionPlus.clases;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {

    private static Validator validator;

    @BeforeEach
    void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValido() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setEstado(1);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdOftalmologo(oftalmologo);
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }

    @Test
    void setFecha_hora() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setFecha_hora(null);
        cita.setEstado(1);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setIdOftalmologo(oftalmologo);
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }


    @Test
    void setEstado() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setEstado(null);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdOftalmologo(oftalmologo);
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }


    @Test
    void setIdPaciente() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setIdPaciente(null);
        cita.setEstado(1);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdOftalmologo(oftalmologo);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }


    @Test
    void setIdOftalmologo() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setIdOftalmologo(null);
        cita.setEstado(1);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }


    @Test
    void setFecha() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setFecha(null);
        cita.setEstado(1);
        cita.setHora(LocalTime.of(10,30));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdOftalmologo(oftalmologo);
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }


    @Test
    void setHora() {
        Usuario paciente = new Usuario();
        Usuario oftalmologo = new Usuario();

        Cita cita = new Cita();
        cita.setHora(null);
        cita.setEstado(1);
        cita.setFecha(LocalDate.of(2025, 5, 20));
        cita.setFecha_hora(Timestamp.valueOf("2025-05-20 10:30:00"));
        cita.setIdOftalmologo(oftalmologo);
        cita.setIdPaciente(paciente);

        Set<ConstraintViolation<Cita>> violations = validator.validate(cita);
        violations.forEach(v -> System.out.println(v.getPropertyPath() + ": " + v.getMessage()));
        assertTrue(violations.isEmpty(), "No deben haber errores de validacion");
    }
}