package com.mixapp.venitar.service;

import com.mixapp.venitar.entity.County;
import com.mixapp.venitar.exception.InvalidCountyException;
import com.mixapp.venitar.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Autowired
    private CountyRepository countyRepository;
    private InvalidCountyException invalidCountyException;


    public List<County> getCounties(){
        List<County> counties = countyRepository.findAll();
        return counties;
    }

    public County getCounty(Long countyId){
        County county = countyRepository.getOne(countyId);
        return county;
    }

    public Boolean checkCounty(Long countyId) {
        return countyRepository.existsById(countyId);
    }

    public County saveCounty(County county){
        return countyRepository.saveAndFlush(county);
    }

    public List<County> saveCounties(List<County> counties){
        List<County> savedCounties = countyRepository.saveAll(counties);
        return savedCounties;
    }

    public County updateCounty(County county) throws InvalidCountyException{
        if (checkCounty(county.getCountyId())){
            return countyRepository.saveAndFlush(county);
        } else {
            throw new InvalidCountyException(invalidCountyException.getInvalidCounty());
        }
    }

    public void deleteCounty(Long countyId) {
        countyRepository.deleteById(countyId);
    }
}
