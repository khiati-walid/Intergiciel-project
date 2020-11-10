package com.example.cloudgateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {

    @GetMapping("defaultPelerins")
        public String message(){

        return "_CircuitBreakerWorking_ ms Vol is not available";
    }
}
