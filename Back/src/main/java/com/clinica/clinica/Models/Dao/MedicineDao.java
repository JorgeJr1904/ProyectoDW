package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Branch;
import com.clinica.clinica.Models.Entities.Medicine;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class MedicineDao {


    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<Medicine> listMedicine(){
        return entityManager.createQuery("FROM Medicine").getResultList();
    }

    public Medicine getMedicine(int id){
        return entityManager.find(Medicine.class, id);
    }

    public Message createMedicine(Medicine medicine){
        Message message = new Message();
        try{
            entityManager.persist(medicine);
            return message.createMessage(201, "Creado Correctamente");
        }catch (Exception e){
            return message.createMessage(201, "Error en el sevidor");
        }
    }

    public Message updateMedicine(int id, Medicine medicine){
        Message message = new Message();
        try{
            Medicine localmedicina = entityManager.find(Medicine.class, id);
            /*localBranch.setCode(branch.getCode());
            localBranch.setAddress(branch.getAddress());
            localBranch.setTel(branch.getTel());*/
            medicine.setId(id);
            entityManager.merge(medicine);
            return message.createMessage(200, "Actualizado Correctamente");
        }catch (Exception e){
            return message.createMessage(500, "Error en el Servidor");
        }
    }

    public Message deleteMedicine(int id){
        try{
            Medicine medicine = entityManager.find(Medicine.class, id);
            entityManager.remove(medicine);
            return message.createMessage(204, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al crear paciente");
        }
    }
}
