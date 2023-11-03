package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.EmployeeDao;
import com.clinica.clinica.Models.Entities.Employee;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping()
    public List<Employee> getEmployees(){
        return employeeDao.getEmployees();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable long id){
        return employeeDao.getEmployee(id);
    }

    @PostMapping("post")
    public Message createEmployee(@RequestBody Employee employee){
        return employeeDao.createEmployee(employee);
    }

    @PutMapping("update/{id}")
    public Message updateEmployee(@RequestBody Employee employee, @PathVariable long id){
        return employeeDao.updateEmployee(employee, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deleteEmployee(@PathVariable long id){
        return employeeDao.deleteEmployee(id);
    }

}
