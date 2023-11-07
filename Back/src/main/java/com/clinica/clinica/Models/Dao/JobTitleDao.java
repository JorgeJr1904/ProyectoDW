package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Exam;
import com.clinica.clinica.Models.Entities.JobTitle;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class JobTitleDao {

    @Autowired
    Message message;

    @PersistenceContext
    EntityManager entityManager;

    public List<JobTitle> getJobTitles(){
        return entityManager.createQuery("FROM JobTitle").getResultList();
    }

    public JobTitle getJobTitle(int id){
        return entityManager.find(JobTitle.class, id);
    }

    public Message createJobTitle(JobTitle jobTitle){
        try{
            if (noRepeatJobTitle(jobTitle.getName())){
                entityManager.persist(jobTitle);
                return message.createMessage(200, "Creado Exitosamente");
            }else {
                return message.createMessage(404, "No se puede Crear un Puesto que ya existe");
            }
        }catch(Exception ex){
            return message.createMessage(500, "Error de Servidor");
        }
    }

    public Message updateJobTitle(JobTitle jobTitle, int id){
        try{
            JobTitle jobTitle1 = entityManager.find(JobTitle.class, id);
            if (jobTitle1 != null){
                entityManager.merge(jobTitle1);
                return message.createMessage(200, "Puesto Actualizado Correctamente");
            }else {
                return message.createMessage(404, "Puesto no existe");
            }
        }catch (Exception e){
            return message.createMessage(500, "Error en el servidor");
        }
    }

    public Message deleteJobTitle(int id){
        try{
            JobTitle jobTitle1 = entityManager.find(JobTitle.class, id);
            if (jobTitle1 != null){
                entityManager.remove(jobTitle1);
                return message.createMessage(200, "Puesto borrado Correctamente");
            }else {
                return message.createMessage(404, "Puesto no existe");
            }
        }catch (Exception e){
            return message.createMessage(500, "Errorr en el servidor");
        }
    }

    private boolean noRepeatJobTitle(String name){
        String sql = "SELECT COUNT(e) FROM JobTitle e WHERE e.name = :jobName";
        Long count = entityManager.createQuery(sql, Long.class)
                .setParameter("jobName", name)
                .getSingleResult();
        return count < 1;
    }

}
