package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.County;
import com.mixapp.venitar.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
    @Query("select c from County c where c.countyName = ?1 ")
    List<County> findCountyByName(String countyName);
}
