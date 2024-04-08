package ma.emsi.evaluationFournisseur.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
public class corsConfiguration {

  //  @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/evaluation/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST"); // Specify the HTTP methods you want to allow
            }
        };
    }
}

