package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Town;
import com.mixapp.venitar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    @Query("select t from Town t where t.townName = ?1 ")
    List<Town> findTownByName(String townName);
}
