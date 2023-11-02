package com.clinica.clinica.RestController.Login;

import com.clinica.clinica.Models.Dao.Login.LoginDao;
import com.clinica.clinica.Models.Dao.ValidTokenDao;
import com.clinica.clinica.Models.Entities.Login.User;
import com.clinica.clinica.Response.AuthMessage;
import com.clinica.clinica.Response.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @Autowired
    ValidTokenDao validTokenDao;

    @GetMapping()
    public AuthMessage authLogin(@RequestBody User user){
        return loginDao.loginAuth(user.getUsername(), user.getPassword());
    }

    @PostMapping("auth")
    public boolean authPromise(@RequestHeader(value = "Authorization") String token){
        return validTokenDao.validToken(token);
    }

}
