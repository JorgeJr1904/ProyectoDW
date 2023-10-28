package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.ExamDao;
import com.clinica.clinica.Models.Entities.Exam;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exam")
public class ExamController {

    @Autowired
    ExamDao examDao;

    @GetMapping()
    public List<Exam> getExams(){
        return examDao.getExams();
    }

    @GetMapping("{id}")
    public Exam getExam(@PathVariable int id){
        return examDao.getExam(id);
    }

    @PostMapping("post")
    public Message createExam(@RequestBody Exam exam){
        return examDao.createExam(exam);
    }

    public Message updateExam(@RequestBody Exam exam, @PathVariable int id){
        return examDao.updateExam(exam, id);
    }

    public Message deleteExam(@PathVariable int id){
        return examDao.deleteExam(id);
    }

}
