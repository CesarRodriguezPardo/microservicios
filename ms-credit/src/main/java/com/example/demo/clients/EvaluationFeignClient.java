package com.example.demo.clients;

import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.SavingAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ms-evaluation",
        path = "/api/v1/evaluation"
)

public interface EvaluationFeignClient {

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


    ///////

    @PostMapping("/saveWorksheet")
    Boolean saveWorksheet(@RequestBody CustomerWorksheetModel customerWorksheetModel);

    @GetMapping("/getAllWorksheet")
    List<CustomerWorksheetModel> getAllWorksheet();

    @GetMapping("/findByRutWorksheet/{rut}")
    CustomerWorksheetModel findByRutWorksheet(String rut);

    @GetMapping("/findByIdWorksheet/{id}")
    CustomerWorksheetModel findByIdWorksheet(@PathVariable Long id);

    @DeleteMapping("/deleteByIdWorksheet/{id}")
    Boolean deleteByIdWorksheet(@PathVariable Long id);

    ////

    @GetMapping("/calculatePayment/{p}/{amount}/{n}")
    public double calculatePayment(@PathVariable float p,
                                              @PathVariable float amount,
                                              @PathVariable float n);
}
