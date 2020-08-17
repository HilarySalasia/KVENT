package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    @Query("select m from Market m where m.itemName = ?1 ")
    Currency findMarketByItemName(String itemName);
}
