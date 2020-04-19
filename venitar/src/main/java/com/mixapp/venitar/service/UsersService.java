package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.exception.InvalidUsersException;
import com.mixapp.venitar.models.VentError;
import com.mixapp.venitar.repository.UsersRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    private InvalidUsersException invalidUsersException;

    private static final File TEMP_DIRECTORY =
            new File(System.getProperty("java.io.tmpdir"));

     public Users addUser(Users user) throws InvalidUsersException {
        Users checkUser = usersRepository.findUsersByEmail(user.getEmail());

        if (checkUser == null) {
             usersRepository.save(user);
            Users saved = usersRepository.findUsersByEmail(user.getEmail());
//            File tmpDir = new File("tmp/venitarL");
//            if (!tmpDir.isDirectory()) {
//                try {
//                     Files.createDirectory(tmpDir.toPath());
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            File newDirectory = new File(TEMP_DIRECTORY,
//                    saved.getUserCode().toString());
//               if (!newDirectory.exists()) {
//                   newDirectory.mkdir();
//                   System.out.println("Directory Successfully Created");
//                   return user;
//               } else {
//                   throw new InvalidUsersException(invalidUsersException.getDupDirectory());
//               }
            return saved;
        } else {
            throw new InvalidUsersException(invalidUsersException.getDupUser());
        }

    }

    public List<Users> findAllUsers() {
         return usersRepository.findAll();
    }

    Users findUsers(Long userId) {
         return usersRepository.getOne(userId);
    }

    List<Users> findUsersByNames(String name) {
         return usersRepository.findUsersByNames(name);
    }

    Users editUsers(Users users) {
         Users conf = usersRepository.getOne(users.getUserCode());
         if (conf != null) {
             return usersRepository.save(users);
         } else {
             return conf;
         }

    }
}
