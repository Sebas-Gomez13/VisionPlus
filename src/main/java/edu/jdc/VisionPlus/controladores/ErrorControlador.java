package edu.jdc.VisionPlus.controladores;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author felipe
 */
@ControllerAdvice
public class ErrorControlador {

    @ExceptionHandler(Exception.class)
    public String manejoErrores(Model vista) {
        return "error";
    }
    
    
}