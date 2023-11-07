package com.clinica.clinica.RestController.Login;

import com.clinica.clinica.Models.Dao.Login.UserDao;
import com.clinica.clinica.Models.Entities.Login.User;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping
    public List<User> listUser(){
        return userDao.listUsers();
    }

    @PostMapping("create")
    public Message createUser(@RequestBody User user){
        return userDao.createUser(user);
    }

    @PutMapping("update")
    public Message updateUser(@PathVariable int id, @RequestBody User user){
        return userDao.updateUser(id, user);
    }

    @DeleteMapping("delete")
    public Message deleteUser(@PathVariable int id){
        return userDao.deleteUser(id);
    }
}
