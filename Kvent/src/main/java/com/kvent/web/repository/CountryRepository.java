package com.kvent.web.repository;

import com.kvent.web.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {



}
