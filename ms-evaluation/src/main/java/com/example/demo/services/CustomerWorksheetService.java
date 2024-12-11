package com.example.demo.services;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.repositories.CustomerWorksheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerWorksheetService {
    @Autowired
    private CustomerWorksheetRepository customerWorksheetRepository;

    public List<CustomerWorksheetEntity> getAll(){return customerWorksheetRepository.findAll();};
    public CustomerWorksheetEntity findByRut(String rut){return customerWorksheetRepository.findByRut(rut);};
}
