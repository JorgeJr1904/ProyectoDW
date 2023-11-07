package com.clinica.clinica.RestController.Login;

import com.clinica.clinica.Dto.PermissionsDto;
import com.clinica.clinica.Models.Dao.Login.RoleDao;
import com.clinica.clinica.Models.Entities.Login.Permission;
import com.clinica.clinica.Models.Entities.Login.Role;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @GetMapping()
    public List<Role> getRoles(){
        return roleDao.listRoles();
    }

    @PostMapping("create")
    public Message createRole(@RequestBody PermissionsDto permissionsDto){
        return roleDao.createRole(permissionsDto.getRole(), permissionsDto.getPermission());
    }

    @DeleteMapping("delete/{id}")
    public Message deleteRole(@PathVariable int id){
        return roleDao.deleteRole(id);
    }
}
