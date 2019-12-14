package com.kvent.web.service;

import com.kvent.web.entity.Town;
import com.kvent.web.repository.TownRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TownService {
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
        town.setTownName(value.getTownName());

        townRepository.save(town);

        return town;
    }

    Town addTown(Town town){
        return  townRepository.save(town);
    }

    String deleteTown(Long id) {
        townRepository.deleteById(id);
        return "Delete Successful";
    }
}
