package com.clinica.clinica.Response;

import lombok.*;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode
@Repository
public class AuthMessage {
    private int status;
    private String message;
    private String token;


    public AuthMessage createMessage(int status, String message, String token){
        return new AuthMessage(status, message, token);
    }
}
