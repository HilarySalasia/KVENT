package com.mixapp.venitar.service;

import com.mixapp.venitar.Generator.KeyGenerator;
import com.mixapp.venitar.entity.Login;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginService {
    @Autowired
    private UsersRepository usersRepository;
    private InvalidLoginException invalidLoginException;
    private KeyGenerator keyGenerator;


    public Login loginUsers(String username, String password) throws InvalidLoginException{
        Users users = usersRepository.findUsersByEmail(username);
        if (users != null) {
            if(users.getCredentials().getPassCode().equals(password)) {
                Login login = new Login();
                login.setLoginToken(keyGenerator.randomAlphaNumeric(4));
                login.setLoginOS("Worked !!");
                return login;
            } else {
                String wrongCredentials = "You have entered wrong username or password";
                throw new InvalidLoginException(wrongCredentials);
            }

        } else {
            String invalidUser = "Invalid User !!";
            throw new InvalidLoginException(invalidUser);
        }
    }
}
