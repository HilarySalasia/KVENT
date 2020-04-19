package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Ward;
import com.mixapp.venitar.exception.InvalidWardException;
import com.mixapp.venitar.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;
    private InvalidWardException invalidWardException;


    public List<Ward> getWards(){
        return wardRepository.findAll();
    }

    public Ward getWard(Long id){
        return wardRepository.getOne(id);
    }

    public Boolean checkWard(Long id) {
        return wardRepository.existsById(id);
    }

    public Ward updateWard(Ward ward) throws InvalidWardException{

        if (checkWard(ward.getWardId())) {
            return wardRepository.saveAndFlush(ward);
        } else {
            throw new InvalidWardException(invalidWardException.invalidWard);
        }
    }

    public Ward addWard(Ward ward) {
        return wardRepository.saveAndFlush(ward);
    }

    public List<Ward> findWardByName(String wardName) {
        return wardRepository.findWardByName(wardName);
    }

    public void deleteWard(Long id) {
        if (checkWard(id)) {
            wardRepository.deleteById(id);
        }
    }
}
