package com.example.login.repository;

import com.example.login.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
//    Optional<List<EmailEntity>> findByFirstName(String firstname);

//    EmailEntity username =  findByFirstName(String firstname);
}
