package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.Event;
import com.mixapp.venitar.entity.Market;
import com.mixapp.venitar.service.CurrencyService;
import com.mixapp.venitar.service.EventService;
import com.mixapp.venitar.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class KVBusController {
    @Autowired
    private EventService eventService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private MarketService marketService;

    // Event
    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/event")
    public Event getEvent(@RequestParam(name = "eventId") Long eventId) {
        return eventService.getEvent(eventId);
    }

    @PutMapping("/updateEvent")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/deleteEvent")
    public void deleteEvent(@RequestParam(name ="eventId") Long eventId) {
        eventService.removeEvent(eventId);
    }

    // Currency
    @PostMapping("/addCurrency")
    public Currency addCurrency(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    @GetMapping("/currencies")
    public List<Currency> getCurrencies() {
        return currencyService.getCurrencies();
    }

    @GetMapping("/currency")
    public Currency getCurrency(@RequestParam("currId") Long currId) {
        return currencyService.getCurrencyById(currId);
    }

    @PutMapping("/updateCurrency")
    public Currency updateCurrency(@RequestBody Currency currency) {
        return currencyService.editCurrency(currency);
    }

    @DeleteMapping("/deleteCurrency")
    public void deleteCurrency(@RequestParam(name = "currId") Long currId) {
        currencyService.removeCurrencies(currId);
    }

    // Market
    @PostMapping("/addMarket")
    public Market addMarket(@RequestBody Market market) {
        return marketService.addMarket(market);
    }

    @GetMapping("/markets")
    public List<Market> getMarkets() {
        return marketService.getMarkets();
    }

    @GetMapping("/market")
    public Market getMarket(@RequestParam("markpId") Long markpId) {
        return marketService.getMarketItem(markpId);
    }

    @PutMapping("/updateMarket")
    public Market updateMarket(@RequestBody Market market) {
        return marketService.updateMarketItem(market);
    }

    @DeleteMapping("/deleteMarket")
    public void deleteMarket(@RequestParam("markpId") Long markpId) {
        marketService.removeMarketItem(markpId);
    }
}
