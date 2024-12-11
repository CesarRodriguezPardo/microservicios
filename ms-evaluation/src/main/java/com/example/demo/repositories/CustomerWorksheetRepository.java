package com.example.demo.repositories;

import com.example.demo.entities.CustomerWorksheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerWorksheetRepository extends JpaRepository<CustomerWorksheetEntity, Long> {
    CustomerWorksheetEntity findByRut(String rut);
    List<CustomerWorksheetEntity> findAll();
}
