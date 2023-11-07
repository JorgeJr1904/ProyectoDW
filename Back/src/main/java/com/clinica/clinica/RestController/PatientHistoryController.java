package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.PatientExamDao;
import com.clinica.clinica.Models.Dao.PatientHistoryDao;
import com.clinica.clinica.Models.Entities.PatientExam;
import com.clinica.clinica.Models.Entities.PatientHistory;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patientHistory")
public class PatientHistoryController {

    @Autowired
    PatientHistoryDao patientHistoryDao;

    @GetMapping()
    public List<PatientHistory> getPatientHistoryDao(){
        return patientHistoryDao.getPatientHistory();
    }


    @GetMapping("{id}")
    public PatientHistory getPatientHistory(@PathVariable int id){
        return patientHistoryDao.getPatientHistory(id);
    }

    @GetMapping("history/{id}")
    public List<PatientHistory> historyList(@PathVariable long id){
        return patientHistoryDao.historyList(id);
    }

    @PostMapping("post")
    public Message createPatientHistory(@RequestBody PatientHistory patientHistory){
        return patientHistoryDao.createPatientHistory(patientHistory);
    }

    @PutMapping("update/{id}")
    public Message updatePatientHistory(@RequestBody PatientHistory patientHistory, @PathVariable int id){
        return patientHistoryDao.updatePatientHistory(patientHistory, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deletePatientHistory(@PathVariable int id){
        return patientHistoryDao.deletePatientHistory(id);
    }

}
