package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.JobTitle;
import com.clinica.clinica.Models.Entities.PatientExam;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientExamDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<PatientExam> getPatientExams() {
        return entityManager.createQuery("FROM PatientExam").getResultList();
    }

    public PatientExam getPatientExam(int id) {
        try {
            PatientExam patientExam = entityManager.find(PatientExam.class, id);
            return patientExam;
        } catch (Exception e) {
            return null;
        }
    }

    public Message createPatientExam(PatientExam patientExam) {
        try {
            entityManager.persist(patientExam);
            return message.createMessage(200, "Creado Exitosamente");
        } catch (Exception ex) {
            return message.createMessage(500, "Error de Servidor");
        }
    }

    public Message updatePatientExam(PatientExam patientExam, int id) {
        try {
            PatientExam patientExam1 = entityManager.find(PatientExam.class, id);
            if (patientExam1 != null) {
                entityManager.merge(patientExam1);
                return message.createMessage(200, "Actualizado Correctamente");
            } else {
                return message.createMessage(404, "no existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }

    public Message deletePatientExam(int id) {
        try {
            PatientExam patientExam1 = entityManager.find(PatientExam.class, id);
            if (patientExam1 != null) {
                entityManager.remove(patientExam1);
                return message.createMessage(200, "Borrado Correctamente");
            } else {
                return message.createMessage(404, "No existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }
}
