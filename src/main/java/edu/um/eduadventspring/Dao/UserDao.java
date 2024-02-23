package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.um.eduadventspring.Model.User;
import java.util.List;



@Repository
public interface UserDao extends JpaRepository<User,Long>{
    
    User findByUsuario(String usuario);

    User findByCodigoId(String codigoId);

    User findByUsuarioAndPasswordAndEscuelaContaining(String usuario, String password, String escuelaContaining);
}
