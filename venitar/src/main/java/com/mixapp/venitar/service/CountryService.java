package com.mixapp.venitar.service;


import com.mixapp.venitar.entity.Country;
import com.mixapp.venitar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    private  EntityManager entityManager;

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
        return countryRepository.saveAndFlush(country);
    }

    Country updateCountry(Country country) {
        Country countryRow = countryRepository.getOne(country.getCountryId());
        return countryRow != null ? countryRepository.saveAndFlush(country) : null;
    }
}
