package com.example.demo.controllers;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.services.CustomerWorksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/worksheet")
@CrossOrigin

public class CustomerWorksheetController {
    @Autowired
    private CustomerWorksheetService customerWorksheetService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerWorksheetEntity>> getAll(){
        return ResponseEntity.ok().body(customerWorksheetService.getAll());
    }

    @GetMapping("/findByRut/{rut}")
    public ResponseEntity<CustomerWorksheetEntity> findByRut(String rut){
        return ResponseEntity.ok().body(customerWorksheetService.findByRut(rut));
    }
}
