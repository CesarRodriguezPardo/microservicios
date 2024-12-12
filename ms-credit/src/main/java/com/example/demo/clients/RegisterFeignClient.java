package com.example.demo.clients;

import com.example.demo.models.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-register",
        path = "/api/v1/user"
)
public interface RegisterFeignClient {

    @GetMapping("/findByRut/{rut}")
    UserModel findByRut(@PathVariable String rut);
}
