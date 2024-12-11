package com.example.demo.clients;

import com.example.demo.models.CustomerWorksheetModel;
import com.example.demo.models.DocumentModel;
import com.example.demo.models.SavingAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "ms-documents",
        path = "/api/v1/document"
)

public interface DocumentsFeignClient {
    @PostMapping("/save")
    Boolean save(@RequestBody DocumentModel documentModel);

    @GetMapping("/findById/{id}")
    DocumentModel findById(@PathVariable Long id);

    @DeleteMapping("/deleteById/{id}")
    Boolean deleteById(@PathVariable Long id);
}
