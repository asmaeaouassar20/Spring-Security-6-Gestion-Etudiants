package algostyle.security.StudentManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Cette annotation active la sécurité au niveau des méthodes pour restreindre l'accès aux services au contrôleurs basés sur des annotations comme "@PreAuthorize" ou "@PostAuthorize"
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()  // Désactiver la protection CSRF (Cross-Site Request Forgery)
                .authorizeHttpRequests((authorize)-> authorize.anyRequest().authenticated())  // Configurer les autorisations pour les requêtes HTTP : ici, toutes les requêtes sont configurées pour nécessiter une authentification
                .httpBasic(Customizer.withDefaults());  // Configurer l'authentification basique HTTP, càd que les utilisateurs devront fournir un nom d'utilisateur et un mdp pour accéder aux ressources protégées


        return http.build(); // Construit et retourne la chaîne de filtres de sécurité configurée
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1= User.builder()
                .username("asmae")
                .password(passwordEncoder().encode("ASMAE123"))
                .roles("ADMIN")
                .build();
        UserDetails user2=User.builder()
                .username("achraf")
                .password(passwordEncoder().encode("ACHRAF123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

}
