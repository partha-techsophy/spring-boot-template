package com.scubetech.demo.domain.model;

import com.scubetech.demo.exception.InvalidInputException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {
    Long id;
    String email;
    String password;
    String name;


    public User changeEmail(String email) throws InvalidInputException {
        if(email == null || email.isEmpty()) {
            throw new InvalidInputException("Invalid email");
        }
        return toBuilder().email(email).build();
    }

    public User changePassword(String password) throws InvalidInputException{
        if(password == null || password.isEmpty()) {
            throw new InvalidInputException("Invalid password");
        }
        return toBuilder().password(password).build();
    }

    public User changeName(String name) throws InvalidInputException{
        if(name == null || name.isEmpty()) {
            throw new InvalidInputException("Invalid name");
        }
        return toBuilder().name(name).build();
    }

    public boolean validatePassword(String password) throws InvalidInputException{

        if(password == null || password.isEmpty() || !this.password.equals(password)) {
            throw new InvalidInputException("Invalid password");
        }

        return true;
    }
}
