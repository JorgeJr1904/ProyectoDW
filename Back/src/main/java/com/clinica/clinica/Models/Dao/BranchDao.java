package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Branch;
import com.clinica.clinica.Models.Entities.Patients;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BranchDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<Branch> listBranches(){
        return entityManager.createQuery("FROM Branch").getResultList();
    }

    public Branch getBranch(int id){
        return entityManager.find(Branch.class, id);
    }

    public Message createBranch(Branch branch){
        Message message = new Message();
        try{
            entityManager.persist(branch);
            return message.createMessage(201, "Creado Correctamente");
        }catch (Exception e){
            return message.createMessage(201, "Error en el sevidor");
        }
    }

    public Message updateBranch(int id, Branch branch){
        Message message = new Message();
        try{
            Branch localBranch = entityManager.find(Branch.class, id);
            /*localBranch.setCode(branch.getCode());
            localBranch.setAddress(branch.getAddress());
            localBranch.setTel(branch.getTel());*/
            branch.setId(id);
            entityManager.merge(branch);
            return message.createMessage(200, "Actualizado Correctamente");
        }catch (Exception e){
            return message.createMessage(500, "Error en el Servidor");
        }
    }

    public Message deleteBranch(int id){
        try{
            Branch branch = entityManager.find(Branch.class, id);
            entityManager.remove(branch);
            return message.createMessage(204, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al crear paciente");
        }
    }
}
