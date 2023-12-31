package com.clinica.clinica.Models.Dao.Login;

import com.clinica.clinica.Models.Entities.Login.Permission;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PermissionDao {

    @Autowired
    Message message;

    ModuleDao moduleDao;

    @PersistenceContext
    EntityManager entityManager;

    public List<Permission> listPermissions(){
        return entityManager.createQuery("FROM Permission").getResultList();
    }

    public Permission getPermission(int id){
        return entityManager.find(Permission.class, id);
    }

    public void createPermissions(int role, List<Permission> permissions){
        Message message = new Message();
        try{
            for (Permission permission: permissions){
                permission.setIdRole(role);
                entityManager.persist(permission);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Termina CRUD ------------------------------------------------------------------------------------------------------------------------------
}
