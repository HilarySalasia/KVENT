package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.MixesUpload;
import com.mixapp.venitar.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency addCurrency(Currency currency) {
        return checkCurrencyByShtDesc(currency.getCurrencyShtDesc()) ? currencyRepository.saveAndFlush(currency) : null;
    }

    public boolean checkCurrencyByShtDesc(String currShtDesc) {
        return currencyRepository.findCurrencyByCurrencyShtDesc(currShtDesc) != null;
    }
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Long currId) {
        return currencyRepository.getOne(currId);
    }

    public Currency editCurrency(Currency curr) {
        Currency curr1 = currencyRepository.getOne(curr.getCurrencyId());
        return curr1 != null ? currencyRepository.saveAndFlush(curr) : null;
    }

    public void removeCurrencies(Long currId) {
        currencyRepository.deleteById(currId);
    }
}
