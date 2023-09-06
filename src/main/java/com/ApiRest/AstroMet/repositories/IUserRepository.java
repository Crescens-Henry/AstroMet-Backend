package com.ApiRest.AstroMet.repositories;

import com.ApiRest.AstroMet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from user where user.name = :name", nativeQuery = true)
    List<User> findUserByName(@Param("name") String name);
    Optional<User> findOneByName(String name);
}

