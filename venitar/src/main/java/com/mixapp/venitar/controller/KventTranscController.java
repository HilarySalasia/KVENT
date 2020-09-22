package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.Transaction;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.repository.LoginRepository;
import com.mixapp.venitar.repository.TransactionRepository;
import com.mixapp.venitar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/KvenTransc")
public class KventTranscController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LoginService loginService;
    private InvalidLoginException invalidLoginException;


    @GetMapping("getAllTransc")
    public List<Transaction> getTransactions(@RequestParam(name = "token") String token)  throws InvalidLoginException {
        
        if (loginService.checkUserLoggedIn(loginService.getUserIDByToken(token))) {
            return transactionRepository.findAll();
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }
    }

    @PostMapping("transact")
    public void makeTransaction(Transaction transaction, String token) throws InvalidLoginException {
        if (loginService.checkUserLoggedIn(loginService.getUserIDByToken(token))) {
            transactionRepository.save(transaction);
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }
    }




}
