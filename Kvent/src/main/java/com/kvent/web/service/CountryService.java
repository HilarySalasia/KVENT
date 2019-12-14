package com.kvent.web.service;

import com.kvent.web.entity.Country;
import com.kvent.web.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class CountryService {
    @PersistenceContext
    private final CountryRepository countryRepository;
    private final EntityManager entityManager;

    public CountryService(CountryRepository countryRepository, EntityManager entityManager) {
        this.countryRepository = countryRepository;
        this.entityManager = entityManager;
    }

    List<Country> getCountries(){
        List<Country> countries ;
        countries = countryRepository.findAll();
        return countries;
    }

    Country getCountriesById(Long id) {
        Country country = countryRepository.getOne(id);
        return country;
    }

    Country saveCountry(Country country){
        Country country1 = countryRepository.save(country);
        return country;
    }


}
