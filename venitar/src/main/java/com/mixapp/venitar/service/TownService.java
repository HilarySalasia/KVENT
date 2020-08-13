package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Town;
import com.mixapp.venitar.exception.InvalidTownException;
import com.mixapp.venitar.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
@Service
public class TownService {
    @Autowired
    private TownRepository townRepository;
    private EntityManager entityManager;
    private InvalidTownException invalidTownException;


    public List<Town> getTowns()  {
        return townRepository.findAll();
    }

    public Town getTown(Long id) {
        return townRepository.getOne(id);
    }

    public Boolean checkTown(Long id) {
        return townRepository.existsById(id);
    }

    public Town updateTown(Town town) throws InvalidTownException {
        if (!checkTown(town.getTownId())){
            return townRepository.save(town);
        } else {
            throw new InvalidTownException(invalidTownException.invalidTown);
        }
    }

    public Town addTown(Town town){
        return  townRepository.saveAndFlush(town);
    }

    public List<Town> findTownByTownName(String townName) {
        return townRepository.findTownByName(townName);
    }

    public void deleteTown(Long id) {
        townRepository.deleteById(id);
    }
}
