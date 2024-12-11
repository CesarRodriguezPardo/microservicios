package com.example.demo.repositories;

import com.example.demo.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    DocumentEntity findByUserId(String userId);
    List<DocumentEntity> findAll();
}