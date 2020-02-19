package com.kvent.web.service;

import com.kvent.web.entity.County;
import com.kvent.web.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Autowired
    private final CountyRepository countyRepository;

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
        return countyRepository.saveAndFlush(county);
    }

    List<County> saveCounties(List<County> counties){
        List<County> savedCounties = countyRepository.saveAll(counties);
        return savedCounties;
    }

    County updateCounty(County county){
        County countyRow =countyRepository.getOne(county.getCountyId());
        return countyRow != null ? countyRepository.saveAndFlush(county) : null;
    }
}
