package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("select c from Currency c where c.currencyShtDesc = ?1 ")
    Currency findCurrencyByCurrencyShtDesc(String currShtDesc);
}
