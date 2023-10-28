package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Models.Entities.Employee;
import com.clinica.clinica.Response.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeDao {

    @Autowired
    Message message;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getEmployees(){
        try{
            String sql = "From Employee";
            entityManager.createQuery(sql).getResultList();
        }catch (Exception ex){
            return null;
        }
        return null;
    }

    public Employee getEmployee(long id){
        try {
            Employee employee = entityManager.find(Employee.class, id);
                return employee;
        }catch (Exception ex){
            return null;
        }
    }

    public Message createEmployee(Employee employee){
        try{
            if (noRepeatEmployee(employee.getId())){
                entityManager.persist(employee);
                return message.createMessage(201, "Creado Correctamente");
            }else {
                return message.createMessage(409, "El DPI del Paciente ya existe o esta Asignado a otra persona");
            }
        }catch (Exception e){
            return message.createMessage(500, "Error inesperado, Intentar Nuevamente");
        }
    }

    public Message updateEmployee(Employee employee, long id){
        try{
            if (employee.getId() == id){
                entityManager.merge(employee);
                return message.createMessage(201, "Actualizado Correctamente");
            }else {
                if (noRepeatEmployee(employee.getId())){
                    entityManager.merge(employee);
                    return message.createMessage(201, "Actualizado Correctamente");
                }else {
                    return message.createMessage(409, "El DPI se encuentra asignado a otro paciente");
                }
            }
        }catch (Exception e){
            return message.createMessage(500, "Error inesperado, Intentar Nuevamente");
        }
    }

    public Message deleteEmployee(long id){
        try{
            Employee employee = entityManager.find(Employee.class, id);
            entityManager.remove(employee);
            return message.createMessage(200, "Paciente Eliminado Correctamente");
        }catch (Exception e){
            return message.createMessage(500, "Error inesperado, Intentar Nuevamente");
        }
    }

    private boolean noRepeatEmployee(long id){
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null){
            return false;
        }else {
            return true;
        }
    }
}
