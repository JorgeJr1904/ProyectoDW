package com.clinica.clinica.Models.Dao.Login;

import com.clinica.clinica.Models.Entities.Login.Role;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ModuleDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<Module> listModules(){
        return entityManager.createQuery("FROM Module").getResultList();
    }

    public Module getModule(int id){
        return entityManager.find(Module.class, id);
    }
}
