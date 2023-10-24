package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Branches;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BranchDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Branches> getBranch (){
        return entityManager.createQuery("FROM Branches").getResultList();
    }

}
