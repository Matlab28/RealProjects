package com.example.login.repository;

import com.example.login.entity.UnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnoRepository extends JpaRepository<UnoEntity, Long> {
}
