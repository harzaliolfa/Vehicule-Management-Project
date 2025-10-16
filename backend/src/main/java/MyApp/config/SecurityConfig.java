package MyApp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        // Disable csrf because we'll use jwt auth
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                // Here we disabled session policy
                .sessionManagement(customizer ->
                        customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Here we don't need authentication only for the login endpoint but for the rest we need auth
                .authorizeHttpRequests(
                        (requests) ->
                            requests.requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
                                    .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }

}
