package com.capellax.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/test")
    public String sayHello() {
        return "Hello from the first controller!";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and message is: " + message;
    }

}
