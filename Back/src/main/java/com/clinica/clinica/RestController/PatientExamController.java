package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.JobTitleDao;
import com.clinica.clinica.Models.Dao.PatientExamDao;
import com.clinica.clinica.Models.Entities.JobTitle;
import com.clinica.clinica.Models.Entities.PatientExam;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patientExam")
public class PatientExamController {

    @Autowired
    PatientExamDao patientExamDao;

    @GetMapping()
    public List<PatientExam> getPatientExamDao(){
        return patientExamDao.getPatientExams();
    }

    @GetMapping("{id}")
    public PatientExam getPatientExamDao(@PathVariable int id){
        return patientExamDao.getPatientExam(id);
    }

    @PostMapping("post")
    public Message createPatientExamDao(@RequestBody PatientExam patientExam){
        return patientExamDao.createPatientExam(patientExam);
    }

    @PutMapping("put/{id}")
    public Message updatePatientExamDao(@RequestBody PatientExam patientExam, @PathVariable int id){
        return patientExamDao.updatePatientExam(patientExam, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deletePatientExamDao(@PathVariable int id){
        return patientExamDao.deletePatientExam(id);
    }

}
