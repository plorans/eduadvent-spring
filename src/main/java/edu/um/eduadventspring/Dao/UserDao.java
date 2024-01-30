package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.um.eduadventspring.Model.User;


@Repository
public interface UserDao extends JpaRepository<User,Long>{
    
    User findByUsuario(String usuario);
}
