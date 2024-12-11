package com.example.demo.clients;

import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.SavingAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ms-evaluation-saving",
        path = "/api/v1/savingAccount"
)

public interface SavingFeignClient {

    @PostMapping("/save")
    Boolean save(@RequestBody SavingAccountModel savingAccountModel);

    @GetMapping("/findByRut/{rut}")
    SavingAccountModel findByRut(String rut);

    @GetMapping("/getAll")
    List<SavingAccountModel> getAll();

    @PostMapping("/rateEvaluation/{rut}")
    Void rateEvaluation(@PathVariable String rut);

    @GetMapping("/findById/{id}")
    SavingAccountModel findById(@PathVariable Long id);

    @DeleteMapping("/deleteById/{id}")
    Boolean deleteById(@PathVariable Long id);
}
