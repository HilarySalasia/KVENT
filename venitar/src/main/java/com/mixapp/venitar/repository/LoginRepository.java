package com.mixapp.venitar.repository;

import com.mixapp.venitar.entity.Login;
import com.mixapp.venitar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query("select t.loginToken from Login t where t.loginToken = ?1 ")
    String findToken(String token);

    @Query("select t from Login t where t.loginToken = ?1 ")
    Login findLoginByToken(String token);

    @Query("select t.userId from Login t where t.userId = ?1 and t.loginLoggedOut = ?2 ")
    Long findTokenByUserId(Long loginUserId, String in);

    @Query("select l from Login l where l.userId= ?1 and l.loginLoggedOut = ?2")
    Login findLoginByUserIdAndLoggedIn(Long loginUserId, String in);

    @Query("select l.userId from Login l where l.loginToken = ?1")
    Long getUserIdByToken(String token);
}
