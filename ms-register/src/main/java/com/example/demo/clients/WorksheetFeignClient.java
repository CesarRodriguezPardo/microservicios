package com.example.demo.clients;

import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.SavingAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ms-evaluation-worksheet",
        path = "/api/v1/worksheet"
)

public interface WorksheetFeignClient {

    @PostMapping("/save")
    Boolean save(@RequestBody CustomerWorksheetModel customerWorksheetModel);

    @GetMapping("/getAll")
    List<CustomerWorksheetModel> getAll();

    @GetMapping("/findByRut/{rut}")
    CustomerWorksheetModel findByRut(String rut);

    @GetMapping("/findById/{id}")
    CustomerWorksheetModel findById(@PathVariable Long id);

    @DeleteMapping("/deleteById/{id}")
    Boolean deleteById(@PathVariable Long id);
}
