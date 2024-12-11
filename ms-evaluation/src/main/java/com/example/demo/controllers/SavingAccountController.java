package com.example.demo.controllers;

import com.example.demo.entities.CustomerWorksheetEntity;
import com.example.demo.entities.SavingAccountEntity;
import com.example.demo.services.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/evaluation")

public class SavingAccountController {
    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SavingAccountEntity>> getAll(){
        return ResponseEntity.ok().body(savingAccountService.getAll());}



    @PostMapping("/rateEvaluation/{rut}")
    public ResponseEntity<Void> rateEvaluation(@PathVariable String rut){
        savingAccountService.rateEvaluation(rut);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByRut/{rut}")
    public ResponseEntity<SavingAccountEntity> findByRut(String rut){
        return ResponseEntity.ok().body(savingAccountService.findByRut(rut));
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody SavingAccountEntity savingAccountEntity){
        return ResponseEntity.ok(savingAccountService.save(savingAccountEntity));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(Long id){
        return ResponseEntity.ok().body(savingAccountService.deleteById(id));
    }
}
