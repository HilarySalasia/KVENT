package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.email = ?1 ")
    Users findUsersByEmail(String email);

    @Query("select u from Users u where u.firstName like %?1% or u.middleName like %?1% or u.surname like %?1%")
    List<Users> findUsersByNames(String name);
}
