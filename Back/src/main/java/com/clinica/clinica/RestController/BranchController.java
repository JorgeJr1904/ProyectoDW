package com.clinica.clinica.RestController;

import com.clinica.clinica.Models.Dao.BranchDao;
import com.clinica.clinica.Models.Entities.Branch;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {

    @Autowired
    BranchDao branchDao;

    @GetMapping
    public List<Branch> getBranches (){
        return branchDao.listBranches();
    }

    @GetMapping("{id}")
    public Branch getBranche (@PathVariable int id){
        return branchDao.getBranch(id);
    }

    @PostMapping(value = "post")
    public Message postBranch(@RequestBody Branch branch){
        return branchDao.createBranch(branch);
    }

    @PutMapping(value = "update")
    public Message updateBranch(@RequestBody Branch branch, @PathVariable int id){
        return branchDao.updateBranch(id, branch);
    }

    @DeleteMapping(value = "delete")
    public Message deleteBranch(@PathVariable int id){
        return branchDao.deleteBranch(id);
    }

}
