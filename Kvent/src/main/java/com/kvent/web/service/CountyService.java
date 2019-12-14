package com.kvent.web.service;

import com.kvent.web.entity.County;
import com.kvent.web.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    private final CountyRepository countyRepository;
    @Autowired
    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    List<County> getAllCounties(){
        List<County> counties = countyRepository.findAll();
        return counties;
    }

    County getCounty(Long countyId){
        County county = countyRepository.getOne(countyId);
        return county;
    }

    County saveCounty(County county){
        County savedCounty = countyRepository.save(county);
        return savedCounty;
    }

    List<County> saveCounties(List<County> counties){
        List<County> savedCounties = countyRepository.saveAll(counties);
        return savedCounties;
    }
}
