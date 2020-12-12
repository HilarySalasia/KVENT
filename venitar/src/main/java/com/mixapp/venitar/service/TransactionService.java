package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Transaction;
import com.mixapp.venitar.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Long addTransaction(Transaction transaction) {
        if (transaction.getAudioId() != null) {
            StopPlayedAudio(transaction.getUserId(), transaction.getAudioId());
        }
        return transactionRepository.save(transaction).getTranscId();
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

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        Set<T> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public List<Transaction> FindUnStoppedAudio(Long userId){
        List<Long> playedTransactionId = transactionRepository.TransactionIdFromTransactionType(1L, userId);
        List<Long> stoppedTransactionRef = transactionRepository.TransactionRefFromTransactionType(4L, userId);
        Long[] transactionUnstoppedId;
        ArrayList<Long> ids = new ArrayList<>();
        for (int y = 0; y < stoppedTransactionRef.size(); y++) {
            for(int x = 0 ; x < playedTransactionId.size(); x++) {
                    if (playedTransactionId.get(x) != stoppedTransactionRef.get(y)) {
                        ids.add(playedTransactionId.get(x));
                    }

                }
        }
        ArrayList<Long> finIds = new ArrayList<>();
        finIds = ids;
//        System.out.println("ids: " + " " + ids);
//        System.out.println("Stopped: " + " " + stoppedTransactionRef);
        for (int y = 0; y < stoppedTransactionRef.size(); y++) {
            for(int k = 0; k < ids.size(); k++) {
                if (ids.get(k) == stoppedTransactionRef.get(y)) {
                    finIds.remove(k);
                }
            }
        }
        finIds = removeDuplicates(finIds);
//        System.out.println("FinIds: " + " " + finIds);
//        transactionUnstoppedId = ids.toArray(new Long[ids.size()]);
        return transactionRepository.findAllById(finIds);
    }

    public void StopPlayedAudio(Long userID, Long audioID) {
        List<Transaction> unstoppedAudio = FindUnStoppedAudio(userID);
        unstoppedAudio.forEach(audio -> {
            if (audio.getAudioId() == audioID) {
                Transaction transaction = new Transaction();
                transaction.setUserId(userID);
                transaction.setTranscRef(audio.getTranscId());
                transaction.setTranscType(4L);
                transaction.setTranscDate(new Date());
                addTransaction(transaction);
            }
        });
    }

    public List<Transaction> FindPlayedAudio(Long userId) {
        return transactionRepository.findAllById(
                transactionRepository.TransactionIdFromTransactionType(1L, userId));
    }

    public List<Transaction> FindPausedAudio(Long userId) {
        return transactionRepository.findAllById(
                transactionRepository.TransactionIdFromTransactionType(3L, userId));
    }

    public List<Transaction> FindValues(Long transcValue, Long userId) {
        return transactionRepository.findAllById(transactionRepository.TransactionValues(transcValue, userId));
    }

}
