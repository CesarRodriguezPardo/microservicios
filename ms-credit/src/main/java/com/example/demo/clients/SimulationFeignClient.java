package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-simulation",
        path = "/api/v1/simulation"
)
public interface SimulationFeignClient {

    @GetMapping("/calculatePayment/{p}/{amount}/{n}")
    double calculatePayment(@PathVariable float p,
                            @PathVariable float amount,
                            @PathVariable float n);
}
