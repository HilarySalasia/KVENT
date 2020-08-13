package com.mixapp.venitar.service;


import com.mixapp.venitar.entity.Country;
import com.mixapp.venitar.exception.InvalidCountryException;
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
    private InvalidCountryException invalidCountryException;

    public List<Country> getCountries(){
        List<Country> countries ;
        countries = countryRepository.findAll();
        return countries;
    }

    public Country getCountriesById(Long id) {
        Country country = countryRepository.getOne(id);
        return country;
    }

    public Country saveCountry(Country country) throws InvalidCountryException{
        Country savedCountry = findCountryByName(country.getName());
        if(savedCountry == null) {
            return countryRepository.saveAndFlush(country);
        } else {
            throw new InvalidCountryException(invalidCountryException.invalidCountry);
        }

    }

    Country updateCountry(Country country) {
        Country countryRow = countryRepository.getOne(country.getCountryId());
        return countryRow != null ? countryRepository.saveAndFlush(country) : null;
    }

    public Country findCountryByName(String name) {
        return countryRepository.findCountryByName(name);
    }
}
