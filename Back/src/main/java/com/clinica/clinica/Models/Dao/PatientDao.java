package com.clinica.clinica.Models.Dao;

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
public class PatientDao {

    @Autowired
    Message message;
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
            return message.createMessage(201, "Paciente Creado");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al crear paciente");
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
            return message.createMessage(200, "Paciente actualizado correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al crear paciente");
        }
    }

    public Message deletePatient(long id){
        try{
            Patients patients = entityManager.find(Patients.class, id);
            entityManager.remove(patients);
            return message.createMessage(204, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return message.createMessage(500, "Error al crear paciente");
        }
    }
}
