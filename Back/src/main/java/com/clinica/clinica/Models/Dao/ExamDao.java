package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Exam;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ExamDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<Exam> getExams(){
        return entityManager.createQuery("FROM Exam").getResultList();
    }

    public Exam getExam(int id){
        return entityManager.find(Exam.class, id);
    }

    public Message createExam(Exam exam){
        try{
            if (noRepeatExam(exam.getName())){
                entityManager.persist(exam);
                return message.createMessage(200, "Creado Exitosamente");
        }else {
                return message.createMessage(404, "No se puede Crear un examen que ya existe");
            }
        }catch(Exception ex){
            return message.createMessage(500, "Error de Servidor");
        }
    }

    public Message updateExam(Exam exam, int id){
        try{
            Exam exam1 = entityManager.find(Exam.class, id);
            if (exam1 != null){
                entityManager.merge(exam1);
                return message.createMessage(200, "Examen Actualizado Correctamente");
            }else {
                return message.createMessage(404, "Examen no existe");
            }
        }catch (Exception e){
            return message.createMessage(500, "Error en el servidor");
        }
    }

    public Message deleteExam(int id){
        try{
            Exam exam1 = entityManager.find(Exam.class, id);
            if (exam1 != null){
                entityManager.remove(exam1);
                return message.createMessage(200, "Examen borrado Correctamente");
            }else {
                return message.createMessage(404, "Examen no existe");
            }
        }catch (Exception e){
            return message.createMessage(500, "Errorr en el servidor");
        }
    }

    private boolean noRepeatExam(String name) {
        String sql = "SELECT COUNT(e) FROM Exam e WHERE e.name = :examName";
        Long count = entityManager.createQuery(sql, Long.class)
                .setParameter("examName", name)
                .getSingleResult();
        return count < 1;
    }

}
