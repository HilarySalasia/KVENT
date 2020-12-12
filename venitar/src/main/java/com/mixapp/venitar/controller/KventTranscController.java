package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.Transaction;
import com.mixapp.venitar.exception.InvalidLoginException;
import com.mixapp.venitar.repository.LoginRepository;
import com.mixapp.venitar.repository.TransactionRepository;
import com.mixapp.venitar.service.LoginService;
import com.mixapp.venitar.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/KvenTransc")
public class KventTranscController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LoginService loginService;
    private InvalidLoginException invalidLoginException;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("getAllTransc")
    public List<Transaction> getTransactions(@RequestParam(name = "token") String token)  throws InvalidLoginException {
        
        if (loginService.checkUserLoggedIn(loginService.getUserIDByToken(token))) {
            return transactionRepository.findAll();
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }
    }

    @PostMapping("transact")
    public Long makeTransaction(@RequestBody Transaction transaction,
                                @RequestParam(name = "token") String token) throws InvalidLoginException {
        if (loginService.checkUserLoggedIn(loginService.getUserIDByToken(token))) {
            return transactionService.addTransaction(transaction);
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }
    }

    @GetMapping("findPausedAudio")
    public List<Transaction> findPausedAudio(@RequestParam(name = "token") String token) throws InvalidLoginException{
        Long userId = loginService.getUserIDByToken(token);
        if (loginService.checkUserLoggedIn(userId)) {
            return transactionService.FindUnStoppedAudio(userId);
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }
    }

    @GetMapping("findTransaction")
    public Optional<Transaction> findTransaction(@RequestParam("transcID") long transcId,
                                                 @RequestParam("token") String token) throws InvalidLoginException {
        Long userId = loginService.getUserIDByToken(token);
        if (loginService.checkUserLoggedIn(userId)) {
            return transactionService.findTransaction(transcId);
        } else {
            throw new InvalidLoginException(invalidLoginException.getInvalidUser());
        }

    }


}
