package com.mixapp.venitar.service;

import com.mixapp.venitar.Generator.KeyGenerator;
import com.mixapp.venitar.entity.Login;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.repository.LoginRepository;
import com.mixapp.venitar.repository.UsersRepository;
import lombok.val;
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
        String generatedString;
        Users users = usersRepository.findUsersByEmail(username);
        if (users != null) {
            if(!checkUserLoggedIn(users.getUserCode())) {
                if(users.getCredentials().getPassCode().equals(password)) {
                    Login login = new Login();
                    RandomString randomString = new RandomString(32);
//                    byte[] array = new byte[32]; // length is bounded by 32
//                    new Random().nextBytes(array);
                    int i = 0;
                    while(i == 0) {
                        generatedString = randomString.nextString();
                        if (checkToken(generatedString)) {
                            i = 0;
                        } else {
                            login.setLoginToken(generatedString);
                            i++;
                        }
                        ;
                    }
                    login.setLoginOS("Worked !!");
                    login.setLoginCookie("7200");
                    Date date = new Date();
                    login.setLoginDate(date);
                    login.setLoginUser(users.getUserCode());
                    login.setLoginLoggedOut("in");

                    return loginRepository.save(login);
                } else {
                    String wrongCredentials = "You have entered wrong username or password";
                    throw new InvalidLoginException(wrongCredentials);
                }
            } else {
                return loginRepository.findLoginByUserIdAndLoggedIn(users.getUserCode(), "in");
            }

        } else {
            String invalidUser = "Invalid User !!";
            throw new InvalidLoginException(invalidUser);
        }
    }

    public Login logoutUser(String token, Date logOutDate) {
        Login loginReg = loginRepository.findLoginByToken(token);
        loginReg.setLoginLoggedOut("out");
        loginReg.setLoginDate(logOutDate);

        return loginReg;
    }

    public Boolean checkToken(String token) {
        return loginRepository.findToken(token) != null;
    }

    public Boolean checkUserLoggedIn(Long loginUserId) {
        return  loginRepository.findTokenByUserId(loginUserId, "in") != null;
    }

    public Long getUserIDByToken(String token) {
        return loginRepository.getUserIdByToken(token);
    }
}
