package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Patients;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Patients> getPatients(){
        return entityManager.createQuery("FROM Patients").getResultList();
    }

    public Patients getPatient(long id){
        return entityManager.find(Patients.class, id);
    }

    public Message createPatient(Patients patients){
        try{
            entityManager.persist(patients);
            return new Message(201, "Creado Exitosamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Message(400, "Error al crear Paciente");
        }
    }

    public Message updatePatient(Patients patients, long id){
        try{
            Patients localPatient = entityManager.find(Patients.class, patients.getId());
            localPatient.setName(patients.getName());
            localPatient.setLastname(patients.getLastname());
            localPatient.setTel(patients.getTel());
            localPatient.setAddress(patients.getAddress());
            localPatient.setEmail(patients.getEmail());
            localPatient.setBlood(patients.getBlood());
            localPatient.setBirthday(patients.getBirthday());
            localPatient.setSex(patients.getSex());
            localPatient.setRoomId(patients.getRoomId());
            return new Message(200, "Actualizado Exitosamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Message(400, "Error al actualizar Paciente");
        }
    }

    public Message deletePatient(long id){
        try{
            entityManager.remove(id);
            return new Message(200, "Eliminado Exitosamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Message(400, "Error al crear Paciente");
        }
    }
}
