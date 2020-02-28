package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.models.VentError;
import com.mixapp.venitar.repository.UsersRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private static final File TEMP_DIRECTORY =
            new File(System.getProperty("java.io.tmpdir"));

    public Users addUser(Users user) {
        List<Users> checkUser = usersRepository.findUsersByEmail(user.getEmail());

        if (checkUser.size() == 0) {
        File newDirectory = new File(TEMP_DIRECTORY,
                user.getUserCode().toString());
        assertFalse(newDirectory.exists());
        assertTrue(newDirectory.mkdir());

        } else{
            user = null;
        }
        return usersRepository.save(user);
    }
}
