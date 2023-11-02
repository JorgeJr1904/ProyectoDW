package com.clinica.clinica.Models.Dao.Login;

import com.clinica.clinica.Models.Entities.Login.User;
import com.clinica.clinica.Response.AuthMessage;
import com.clinica.clinica.Utils.JWTUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoginDao {

    @Autowired
    AuthMessage authMessage;

    @Autowired
    private JWTUtil jwtUtil;

    @PersistenceContext
    EntityManager entityManager;

    public AuthMessage loginAuth(String username, String pass){
        User user = findUser(username);
        if (user != null){
            if (BCrypt.checkpw(pass, user.getPassword())){
                String token = jwtUtil.create(String.valueOf(user.getId()), user.getUsername(), user.getIdRole());
                return authMessage.createMessage(200, "Login Exitoso", token);
            }else {
                return authMessage.createMessage(404, "Usuario o Contrasenia Incorrecta", "");
            }
        }else {
            return authMessage.createMessage(404, "Usuario no Encontrado", "");
        }

    }


    private User findUser(String name){
        try{
            String sql = "SELECT u FROM User u WHERE u.username= :name";
            return entityManager.createQuery(sql, User.class).setParameter("name", name).getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }

}
