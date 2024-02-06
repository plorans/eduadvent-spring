package edu.um.eduadventspring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import edu.um.eduadventspring.Dao.UserDao;

@Configuration
public class PasswordStorageWebSecurityConfigurer {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @Bean
    public UserDetailsService getUserDefaultDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
                
                edu.um.eduadventspring.Model.User user = userDao.findByUsuario(usuario);
                if (user == null) {
                    throw new UsernameNotFoundException("Invalid username or password.");
                }

                return org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsuario())

                        .password( passwordEncoder.encode(user.getPassword()))
                        .roles(user.getRole())
                        .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                        .build();
            }
        };
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, CustomPasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.eraseCredentials(false)
                .userDetailsService(getUserDefaultDetailsService())
                .passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    
    

    
}
