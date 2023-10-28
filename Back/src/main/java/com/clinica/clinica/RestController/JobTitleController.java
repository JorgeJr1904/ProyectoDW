package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.JobTitleDao;
import com.clinica.clinica.Models.Entities.JobTitle;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobTitle")
public class JobTitleController {

    @Autowired
    JobTitleDao jobTitleDao;

    @GetMapping()
    public List<JobTitle> getJobTitle(){
        return jobTitleDao.getJobTitles();
    }

    @GetMapping("{id}")
    public JobTitle getJobTitle(@PathVariable int id){
        return jobTitleDao.getJobTitle(id);
    }

    @PostMapping("post")
    public Message createJobTitle(@RequestBody JobTitle jobTitle){
        return jobTitleDao.createJobTitle(jobTitle);
    }

    @PutMapping("put/{id}")
    public Message updateJobTitle(@RequestBody JobTitle jobTitle, @PathVariable int id){
        return jobTitleDao.updateJobTitle(jobTitle, id);
    }

    @DeleteMapping("delete/{id}")
    public Message deleteJobTitle(@PathVariable int id){
        return jobTitleDao.deleteJobTitle(id);
    }

}
