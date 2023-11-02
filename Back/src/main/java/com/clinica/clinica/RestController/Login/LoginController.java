package com.clinica.clinica.RestController.Login;

import com.clinica.clinica.Models.Dao.Login.LoginDao;
import com.clinica.clinica.Models.Entities.Login.User;
import com.clinica.clinica.Response.AuthMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @GetMapping()
    public AuthMessage authLogin(@RequestBody User user){
        return loginDao.loginAuth(user.getUsername(), user.getPassword());
    }

}
