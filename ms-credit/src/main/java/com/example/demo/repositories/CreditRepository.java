package com.example.demo.repositories;

import com.example.demo.entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity, Long> {
    List<CreditEntity> findByRut(String rut);
    List<CreditEntity> findAll();
}