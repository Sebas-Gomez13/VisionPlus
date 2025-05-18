package edu.jdc.VisionPlus.config;

import edu.jdc.VisionPlus.clases.Usuario;
import edu.jdc.VisionPlus.daos.UsuarioDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UsuarioDAO usuarioService;

    // Definir el interceptor en la misma clase de configuración
    @Bean
    public HandlerInterceptor userInterceptor() {
        return new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                Usuario user = usuarioService.authenticationUser();
                request.setAttribute("user", user);  // Guardamos el usuario en la solicitud
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                                   org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
                if (modelAndView != null) {
                    modelAndView.addObject("user", request.getAttribute("user"));  // Agregamos el usuario al modelo
                }
            }
        };
    }

    // Registrar el interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/**");  // Asegúrate de que se ejecute en todas las rutas
    }
}

