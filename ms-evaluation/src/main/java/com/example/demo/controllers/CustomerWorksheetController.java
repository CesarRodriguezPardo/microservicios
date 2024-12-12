package com.example.demo.controllers;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.services.CustomerWorksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/evaluation")
public class CustomerWorksheetController {
    @Autowired
    private CustomerWorksheetService customerWorksheetService;

    @GetMapping("/getAllWorksheet")
    public ResponseEntity<List<CustomerWorksheetEntity>> getAllWorksheet(){
        return ResponseEntity.ok().body(customerWorksheetService.getAll());
    }

    @GetMapping("/findByRutWorksheet/{rut}")
    public ResponseEntity<CustomerWorksheetEntity> findByRutWorksheet(String rut){
        return ResponseEntity.ok().body(customerWorksheetService.findByRut(rut));
    }

    @PostMapping("/saveWorksheet")
    public ResponseEntity<Boolean> saveWorksheet(@RequestBody CustomerWorksheetEntity customerWorksheetEntity){
        return ResponseEntity.ok(customerWorksheetService.save(customerWorksheetEntity));
    }

    @GetMapping("/findByIdWorksheet/{id}")
    public ResponseEntity<CustomerWorksheetEntity> findByIdWorksheet(Long id){
        return ResponseEntity.ok().body(customerWorksheetService.findById(id));
    }

    @DeleteMapping("/deleteByIdWorksheet/{id}")
    public ResponseEntity<Boolean> deleteByIdWorksheet(Long id){
        return ResponseEntity.ok().body(customerWorksheetService.deleteById(id));
    }
}
