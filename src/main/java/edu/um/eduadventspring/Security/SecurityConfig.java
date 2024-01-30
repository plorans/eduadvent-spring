package edu.um.eduadventspring.Security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.um.eduadventspring.Dao.UserDao;
import edu.um.eduadventspring.Model.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin((formLogin) -> formLogin
                        .defaultSuccessUrl("/inicio")
                        .permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
                User user = userDao.findByUsuario(usuario);
                if (user == null) {
                    throw new UsernameNotFoundException("Invalid username or password.");
                }
                String encodedPassword = passwordEncoder().encode(user.getPassword());
                return org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsuario())
                        .password(encodedPassword)
                        .roles(user.getRole())
                        .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                        .build();
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String defaultAlgorithm = "MD5";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(defaultAlgorithm, PasswordEncoderFactories.createDelegatingPasswordEncoder());

        return new DelegatingPasswordEncoder(defaultAlgorithm, encoders);
    }

}
