package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.Login;
import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.exception.InvalidUsersException;
import com.mixapp.venitar.service.LoginService;
import com.mixapp.venitar.service.MixesUploadService;
import com.mixapp.venitar.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KventController {
 @Autowired
 JdbcTemplate jdbcTemplate;
 @Autowired
 private MixesUploadService mixesUploadService;
 @Autowired
 private UsersService usersService;
 @Autowired
 private LoginService loginService;

 @GetMapping("/")
 public String index() {
  return "Greetings from Spring Boot!";
 }

 @PostMapping("/addUser")
 Users addUser(@RequestBody Users users) throws InvalidUsersException { return usersService.addUser(users);
 }
 @PostMapping("/login")
 Login loginUser(@RequestParam(name="username") String username,
                 @RequestParam(name = "password") String password) throws InvalidLoginException{
  return loginService.loginUsers(username, password);
 }

 @GetMapping("/getAllUser")
 List<Users> getAllUser() throws InvalidUsersException { return usersService.findAllUsers();}

 @GetMapping("/getAllMixes")
 List<MixesUpload> getAllMixes() {
  return mixesUploadService.getAllMixes();
 }

 @GetMapping("/getMixById")
 MixesUpload getMix(@RequestParam(name = "MixID") Long mixId){
 return mixesUploadService.getMixUpload(mixId);
 }

 @PostMapping("/addMix")
 MixesUpload addMix(@RequestBody MixesUpload mix) {
 return mixesUploadService.uploadMix(mix);
 }

 @PutMapping("/updateMix")
 MixesUpload updateMix(@RequestBody MixesUpload mix) {
 return mixesUploadService.updateMixUpload(mix);
 }

 @DeleteMapping("/delMix")
 void deleteMix(@RequestParam(name = "mixID") Long mixId){
    mixesUploadService.deleteMixUpload(mixId);
  }

}
