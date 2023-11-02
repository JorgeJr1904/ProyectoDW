package com.clinica.clinica.Models.Dao;

import com.clinica.clinica.Utils.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ValidTokenDao {

    @Autowired
    private JWTUtil jwtUtil;

    public boolean validToken(String token){
        try{
            String userId = jwtUtil.getKey(token);
            return userId != null;
        }catch (ExpiredJwtException | MalformedJwtException ex){
            ex.printStackTrace();
            return false;
        }catch(SignatureException ex){
            return false;
        }
    }
}
