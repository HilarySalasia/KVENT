package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
    @Query("select t From Transaction t where t.transcDate = ?1")
    Transaction TransactionByDate(Date transcDate);

    @Query("select t from Transaction t where t.userId = ?1")
    Transaction TransactionByUser(Long transcUserId);

    @Query("select t from Transaction t where t.transcType = ?1")
    Transaction TransactionByType(Long transcType);

    @Query("select t from Transaction t where t.audioId = ?1")
    Transaction TransactionByAudioId(Long audioId);

    @Query("select t from Transaction t where t.audioId = ?1 and t.transcDate = ?2")
    Transaction TransactionByAudioIdAndDate(Long audioId, Date transcDate);
}
