package bozntouran.reviewmycert.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(13));

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/users/newUser").permitAll()
                        .requestMatchers("/api/company").permitAll()
                        .requestMatchers("/api/company/**").permitAll()
                        .requestMatchers("/api/company-new").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/company-delete/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/company-patch").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/certificate").permitAll()
                        .requestMatchers("/api/certificate/**").permitAll()
                        .requestMatchers("/api/certificate-new").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/certificate-delete/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/certificate-patch").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/users/all").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/company").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
