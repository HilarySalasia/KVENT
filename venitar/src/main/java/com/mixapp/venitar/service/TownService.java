package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Town;
import com.mixapp.venitar.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
@Service
public class TownService {

    private TownRepository townRepository;
    private EntityManager entityManager;



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
        townRepository.deleteById(id);
        return "Delete Successful";
    }
}
