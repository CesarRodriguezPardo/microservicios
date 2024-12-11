package com.example.demo.controllers;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.services.CustomerWorksheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/worksheet")
@CrossOrigin

public class CustomerWorksheetController {
    @Autowired
    private CustomerWorksheetService customerWorksheetService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerWorksheetEntity>> getAllWorksheet(){
        return ResponseEntity.ok().body(customerWorksheetService.getAll());
    }

    @GetMapping("/findByRut/{rut}")
    public ResponseEntity<CustomerWorksheetEntity> findByRutWorksheet(String rut){
        return ResponseEntity.ok().body(customerWorksheetService.findByRut(rut));
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveWorksheet(@RequestBody CustomerWorksheetEntity customerWorksheetEntity){
        return ResponseEntity.ok(customerWorksheetService.save(customerWorksheetEntity));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CustomerWorksheetEntity> findByIdWorksheet(Long id){
        return ResponseEntity.ok().body(customerWorksheetService.findById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteByIdWorksheet(Long id){
        return ResponseEntity.ok().body(customerWorksheetService.deleteById(id));
    }
}
