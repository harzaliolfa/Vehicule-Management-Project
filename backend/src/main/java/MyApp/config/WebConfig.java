package MyApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                        // the backend allows the browser to include credentials(cookies, authorization headers, TLS,
                        // client certificates) when making cross-origin requests
                        .allowCredentials(true)
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }
}
