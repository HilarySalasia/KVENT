package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Users;
import com.mixapp.venitar.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {
    @Query("select w from Ward w where w.wardName = ?1 ")
    List<Ward> findWardByName(String wardName);
}
