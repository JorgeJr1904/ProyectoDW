package com.clinica.clinica.Response;

import lombok.*;
import org.springframework.stereotype.Repository;

@ToString @EqualsAndHashCode @Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Message {

    private int status;
    private String message;


    public Message createMessage(int status, String message){
        Message message1 = new Message(status, message);
        return message1;
    }
}
