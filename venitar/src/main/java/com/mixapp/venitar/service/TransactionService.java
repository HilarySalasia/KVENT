package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Transaction;
import com.mixapp.venitar.repository.TransactionRepository;

import java.util.Date;
import java.util.Optional;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Optional<Transaction> findTransaction(Long transcId) {
        return transactionRepository.findById(transcId);
    }

    public Transaction findByDate(Date transcDate) {
        return transactionRepository.TransactionByDate(transcDate);
    }

    public Transaction findByUser(Long transcUser) {
        return transactionRepository.TransactionByUser(transcUser);

    }

    public Transaction findByDate(Long transcType) {
        return transactionRepository.TransactionByType(transcType);
    }

    public Transaction findByAudio(Long audioId) {
        return transactionRepository.TransactionByAudioId(audioId);
    }

    public Transaction TransactionByAudioAndDate(Long audioId, Date transcDate) {
        return transactionRepository.TransactionByAudioIdAndDate(audioId, transcDate);
    }

}
