package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.PatientExam;
import com.clinica.clinica.Models.Entities.PatientHistory;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PatientHistoryDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<PatientHistory> getPatientHistory() {
        return entityManager.createQuery("FROM PatientHistory").getResultList();
    }

    public PatientHistory getPatientHistory(int id) {
        try {
            PatientHistory patientHistory = entityManager.find(PatientHistory.class, id);
            return patientHistory;
        } catch (Exception e) {
            return null;
        }
    }

    public Message createPatientHistory(PatientHistory patientHistory) {
        try {
            entityManager.persist(patientHistory);
            return message.createMessage(200, "Creado Exitosamente");
        } catch (Exception ex) {
            return message.createMessage(500, "Error de Servidor");
        }
    }

    public Message updatePatientHistory(PatientHistory patientHistory, int id) {
        try {
            PatientHistory patientHistory1 = entityManager.find(PatientHistory.class, id);
            if (patientHistory1 != null) {
                entityManager.merge(patientHistory1);
                return message.createMessage(200, "Actualizado Correctamente");
            } else {
                return message.createMessage(404, "no existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }

    public Message deletePatientHistory(int id) {
        try {
            PatientHistory patientHistory1 = entityManager.find(PatientHistory.class, id);
            if (patientHistory1 != null) {
                entityManager.remove(patientHistory1);
                return message.createMessage(200, "Borrado Correctamente");
            } else {
                return message.createMessage(404, "No existe");
            }
        } catch (Exception e) {
            return message.createMessage(500, "Error en el servidor");
        }
    }
}
