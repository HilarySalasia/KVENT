package com.mixapp.venitar.controller;

import com.mixapp.venitar.entity.*;
import com.mixapp.venitar.exception.*;
import com.mixapp.venitar.repository.CountryRepository;
import com.mixapp.venitar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setup")
public class SetupController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CountryService countryService;
    @Autowired
    CompanyService companyService;
    @Autowired
    WardService wardService;
    @Autowired
    CountyService countyService;
    @Autowired
    PictureService pictureService;
    @Autowired
    TownService townService;

    InvalidCountryException invalidCountryException;
    //Country Setup
    @GetMapping("getCountries")
    List<Country> getCountries() {
        return countryService.getCountries();
    }
    @GetMapping("getCountry")
    Country getCountry(@RequestParam(name = "countryId") Long countryId) {
        return countryService.getCountriesById(countryId);
    }

    @PostMapping("addCountry")
    Country addCountry(@RequestBody Country country) throws InvalidCountryException {
        return countryService.saveCountry(country);
    }
    //County Setup
    @GetMapping("getCounties")
    List<County> getAllCounties() {return countyService.getCounties();}

    @PostMapping("addCounty")
    County addCounty(@RequestBody County county) {return countyService.saveCounty(county);}

    @PutMapping("updateCounty")
    County updateCounty(@RequestBody County  county) throws InvalidCountyException
    {return countyService.updateCounty(county);}

    @DeleteMapping("delCounty")
    void deleteCounty(@RequestParam(name = "countyID") Long id) {countyService.deleteCounty(id);}

    //Company Setup
    @GetMapping("getCompanies")
    List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping("addCompany")
    Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @PutMapping("updateCompany")
    Company updateCompany(@RequestBody Company company) throws InvalidCompanyException {
        return companyService.editCompany(company);
    }

    @GetMapping("findCompany")
    Company findCompany(@RequestParam(name = "companyID") Long companyId) {
        return companyService.findCompany(companyId);
    }

    @DeleteMapping("delCompany")
    void delCompany(@RequestParam(name = "companyId") Long compId) {
        companyService.delCompany(compId);
    }

    //Ward Setup
    @GetMapping("getWards")
    List<Ward> getWards() {
        return wardService.getWards();
    }
    @PostMapping("addWard")
    Ward addWard(@RequestBody Ward ward) { return wardService.addWard(ward);}

    @PutMapping("updateWard")
    Ward updateWard(Ward ward) throws InvalidWardException {return wardService.updateWard(ward);}

    @GetMapping("findWard")
    Ward findWard(@RequestParam(name = "wardID") Long wardId){
        return wardService.getWard(wardId);
    }

    @DeleteMapping("deleteWard")
    void deleteWard(@RequestParam(name = "wardID") Long wardId) {
        wardService.deleteWard(wardId);
    }
    // Picture Setup
    @GetMapping("getPictures")
    List<Picture> getPictures() {
        return pictureService.findPictures();
    }

    @GetMapping("getPictureById")
    Picture getPictureById(Long picId) {
        return pictureService.findPicture(picId);
    }

    @PostMapping("addPicture")
    Picture addPicture(@RequestBody Picture picture) {
        return pictureService.addPicture(picture);
    }

    @GetMapping("getTowns")
    List<Town> getTowns(){
        return townService.getTowns();
    }

    @GetMapping("getTown")
    Town getTown(@RequestParam(name = "townId") Long townId){
        return townService.getTown(townId);
    }

    @PutMapping("updateTown")
    Town updateTown(@RequestBody Town town) throws InvalidTownException {
        return townService.updateTown(town);
    }

    @DeleteMapping("deleteTown")
    void deleteTown(Long townId){
        townService.deleteTown(townId);
    }
}
