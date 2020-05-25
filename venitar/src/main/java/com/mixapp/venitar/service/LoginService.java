package com.mixapp.venitar.service;

import com.mixapp.venitar.Generator.KeyGenerator;
import com.mixapp.venitar.entity.Login;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.repository.LoginRepository;
import com.mixapp.venitar.repository.UsersRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class LoginService {
    @Autowired
    private UsersRepository usersRepository;
    private InvalidLoginException invalidLoginException;
    @Autowired
    private LoginRepository loginRepository;
//    private KeyGenerator keyGenerator;
//    private RandomStringUt randomString;


    public Login loginUsers(String username, String password) throws InvalidLoginException{
        Users users = usersRepository.findUsersByEmail(username);
        if (users != null) {
            if(users.getCredentials().getPassCode().equals(password)) {
                Login login = new Login();
                byte[] array = new byte[7]; // length is bounded by 7
                new Random().nextBytes(array);
                String generatedString = new String(array, StandardCharsets.UTF_8);
                login.setLoginToken(generatedString);
                login.setLoginOS("Worked !!");
                login.setLoginCookie("7200");
                Date date = new Date();
                login.setLoginDate(date);
                login.setLoginUser(users);

                return loginRepository.save(login);
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
