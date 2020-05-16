package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.Event;
import com.mixapp.venitar.repository.EventRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return checkEventByEventTitle(event.getEventTitle()) ? eventRepository.saveAndFlush(event) : null;
    }

    public boolean checkEventByEventTitle(String eventTitle) {
        return eventRepository.findEventByEventTitle(eventTitle) != null;
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Event getEvent(Long eventId) {
        return eventRepository.getOne(eventId);
    }

    public Boolean checkEvent(Long eventId) {
        return eventRepository.existsById(eventId);
    }

    public Event updateEvent(Event event) {
        val checkEvent = checkEvent(event.getEventId());
        return checkEvent != null ? eventRepository.saveAndFlush(event) : null;
    }

    public void removeEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
