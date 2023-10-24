package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.BranchDao;
import com.clinica.clinica.Models.Entities.Branches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {

    @Autowired
    BranchDao branchDao;

    @GetMapping
    public List<Branches> getBranches (){
        return branchDao.getBranch();
    }

}
