package edu.um.eduadventspring.Security;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.UserDao;
import edu.um.eduadventspring.Model.User;

@Service
public class UserDetail implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        User user = userDao.findByUsuario(usuario);
        if (user == null) {
            new UsernameNotFoundException("User not exists by Username");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (user.getAdministrador() != null && !user.getAdministrador().isEmpty()) {
            authorities.add(new SimpleGrantedAuthority(user.getAdministrador()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getPassword(),
                authorities);

    }

}