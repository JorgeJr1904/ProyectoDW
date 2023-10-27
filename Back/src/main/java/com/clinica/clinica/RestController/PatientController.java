package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.PatientDao;
import com.clinica.clinica.Models.Entities.Patients;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientDao patientDao;

    @GetMapping()
    public List<Patients> getPatientList(){
        return patientDao.getPatients();
    }

    @GetMapping("{id}")
    public Patients getPatient(@PathVariable long id){
        return patientDao.getPatient(id);
    }

    @PostMapping("post")
    public Message createPatient(@RequestBody Patients patient){
        return patientDao.createPatient(patient);
    }

    @PutMapping("update/{id}")
    public Message updatePatient(@PathVariable long id, @RequestBody Patients patient){
        return patientDao.updatePatient(patient, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deletePatient(@PathVariable long id){
        return patientDao.deletePatient(id);
    }

}
