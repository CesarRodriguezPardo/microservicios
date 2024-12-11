package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ms-documents",
        path = "/api/v1/document"
)

public interface DocumentsFeignClient {

}
