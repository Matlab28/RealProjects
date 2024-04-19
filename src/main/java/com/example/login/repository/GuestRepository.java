package com.example.login.repository;

import com.example.login.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
    @Query(value = "SELECT * FROM guest WHERE age >= :minAge", nativeQuery = true)
    Optional<List<GuestEntity>> findByMinAge(@Param("minAge") Integer minAge);
}
