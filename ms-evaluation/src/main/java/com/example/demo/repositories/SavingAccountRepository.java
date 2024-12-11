package com.example.demo.repositories;

import com.example.demo.entities.SavingAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccountEntity, Long> {
    SavingAccountEntity findByRut(String rut);
    List<SavingAccountEntity> findAll();
}
