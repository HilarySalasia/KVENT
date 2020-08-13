package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Country;
import com.mixapp.venitar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("select c from Country c where c.name = ?1 ")
    Country findCountryByName(String name);


}
