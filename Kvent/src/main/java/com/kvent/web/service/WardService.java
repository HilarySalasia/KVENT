package com.kvent.web.service;

import com.kvent.web.entity.Ward;
import com.kvent.web.repository.WardRepository;

import java.util.List;

public class WardService {
    private final WardRepository wardRepository;

    public WardService(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    List<Ward> getWards(){
        return wardRepository.findAll();
    }

    Ward getWard(Long id){
        return wardRepository.getOne(id);
    }

    Ward updateWard(Ward ward) {
        Ward wardRow = getWard(ward.getWardId());
        wardRow.setWardName(ward.getWardName());
        return wardRow;
    }

    Ward addWard(Ward ward) {
        return wardRepository.save(ward);
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
