package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Event;
import com.mixapp.venitar.entity.Market;
import com.mixapp.venitar.repository.MarketRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    @Autowired
    private MarketRepository marketRepository;

    public Market addMarket(Market market) {
        return checkMarketByItemName(market.getItemName()) ? marketRepository.saveAndFlush(market) : null;
    }

    public boolean checkMarketByItemName(String itemName) {
        return marketRepository.findMarketByItemName(itemName) != null;
    }

    public List<Market> getMarkets(){
        return marketRepository.findAll();
    }

    public Market getMarketItem(Long markpId) {
        return marketRepository.getOne(markpId);
    }

    public boolean checkMarket(Long markpId) {
        return marketRepository.existsById(markpId);
    }

    public Market updateMarketItem(Market markpItem) {
        val checkMarkp = checkMarket(markpItem.getMarketId());
        return checkMarkp ? marketRepository.saveAndFlush(markpItem) : null;
    }

    public void removeMarketItem(Long markpId) {
        marketRepository.deleteById(markpId);
    }
}
