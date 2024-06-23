package Config;

import org.springframework.web.filter.CorsFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class Config {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("https://7f64-186-30-9-175.ngrok-free.app"); // Tu URL de Ngrok
        config.addAllowedOrigin("http://localhost:3000"); // Para desarrollo local
        config.addAllowedHeader("*"); // Permite cualquier encabezado
        config.addAllowedMethod("*"); // Permite cualquier método HTTP (GET, POST, etc.)
        config.setAllowCredentials(true); // Permite el uso de cookies y credenciales

        source.registerCorsConfiguration("/**", config); // Aplica esta configuración a todas las rutas
        return new CorsFilter(source);
    }
}
