package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Currency;
import com.mixapp.venitar.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.eventTitle = ?1 ")
    Currency findEventByEventTitle(String eventTitle);
}
