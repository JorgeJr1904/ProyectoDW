package com.clinica.clinica.Models.Dao.Login;


import com.clinica.clinica.Models.Entities.Login.User;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<User> listUsers(){
        return (List<User>) entityManager.createQuery("FROM User u").getResultList();
    }

    public User getUser(int id){
        return entityManager.find(User.class, id);
    }

    public Message createUser(User user){
        Message message = new Message();
        try{
            if (noRepeatUser(user.getUsername())){
                if (securePass(user.getPassword())){
                    user.setPassword(encryptPass(user.getPassword()));
                    entityManager.persist(user);
                    return message.createMessage(201, "Creado Correctamente");
                }else {
                    return message.createMessage(404, "Password no segura");
                }
            }else {
                return message.createMessage(404, "Usuario No valido o ya existente");
            }
        }catch (Exception e){
            return message.createMessage(505, "Error en el sevidor");
        }
    }

    public Message updateUser(int id, User user){
        Message message = new Message();
        User localUser = entityManager.find(User.class, id);
        try{
            if (localUser.getUsername().equals(user.getUsername())){
                if (securePass(user.getPassword())){
                    user.setId(id);
                    user.setPassword(encryptPass(user.getPassword()));
                    entityManager.merge(user);
                    return message.createMessage(200, "Actualizado Correctamente");
                }else {
                    return message.createMessage(404, "Password no segura");
                }
            }else if (noRepeatUser(user.getUsername())){
                if (securePass(user.getPassword())){
                    user.setId(id);
                    user.setPassword(encryptPass(user.getPassword()));
                    entityManager.merge(user);
                    return message.createMessage(200, "Actualizado Correctamente");
                }else {
                    return message.createMessage(404, "Password no segura");
                }
            }else{
                return message.createMessage(404, "Usuario No valido o ya existe");
            }

        }catch (Exception e){
            return message.createMessage(500, "Error en el Servidor");
        }
    }

    public Message deleteUser(int id){
        try{
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            return message.createMessage(204, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al eliminar paciente");
        }
    }

    //Termina CRUD ------------------------------------------------------------------------------------------------------------------------------

    private boolean noRepeatUser(String name){
        String sql = "SELECT COUNT(e) FROM User e WHERE e.username = :jobName";
        Long count = entityManager.createQuery(sql, Long.class)
                .setParameter("jobName", name)
                .getSingleResult();
        return count < 1;
    }

    private String encryptPass(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }

    //Verification requisits of security password
    public static boolean securePass(String pass){
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_ -])[A-Za-z\\d@$!%*?&_ -]{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);

        return matcher.matches();
    }
}
