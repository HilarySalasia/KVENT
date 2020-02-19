package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.Ward;
import com.mixapp.venitar.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class WardService {
    @Autowired
    private WardRepository wardRepository;



    List<Ward> getWards(){
        return wardRepository.findAll();
    }

    Ward getWard(Long id){
        return wardRepository.getOne(id);
    }

    Ward updateWard(Ward ward) {
        Ward wardRow = wardRepository.getOne(ward.getWardId());

        return wardRow != null ? wardRepository.saveAndFlush(ward) : null;
    }

    Ward addWard(Ward ward) {
        return wardRepository.saveAndFlush(ward);
    }

    String deleteWard(Long id) {
        Ward fetchWard = getWard(id);
        if(fetchWard != null) {
            wardRepository.deleteById(id);
            return "Successfully Deleted Ward!!";
        } else {
            return "Ward to Delete wasn't Found!";
        }
    }
}
