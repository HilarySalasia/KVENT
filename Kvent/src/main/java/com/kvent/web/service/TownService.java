package com.kvent.web.service;

import com.kvent.web.entity.Town;
import com.kvent.web.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class TownService {
    @Autowired
    private final TownRepository townRepository;
    private final EntityManager entityManager;

    public TownService(TownRepository townRepository, EntityManager entityManager) {
        this.townRepository = townRepository;
        this.entityManager = entityManager;
    }

    List<Town> getAllTowns()  {
        return townRepository.findAll();
    }

    Town getTown(Long id) {
        return townRepository.getOne(id);
    }

    Town updateTown(Town value) {

        Town town = entityManager.find(Town.class, value.getTownId());


       return town != null ? townRepository.save(value) : null;
    }

    Town addTown(Town town){
        return  townRepository.saveAndFlush(town);
    }

    String deleteTown(Long id) {
        townRepository.delete(id);
        return "Delete Successful";
    }
}
