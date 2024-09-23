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

    @PostMapping("/order")
    public String order(
            @RequestBody Order order
    ) {
        return "Order reveived: " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String orderRecord(
            @RequestBody OrderRecord order
    ) {
        return "Order reveived: " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ) {
        return "my value = " + userName;
    }

    @GetMapping("/hello")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastname
    ) {
        return "my value = " + userName + " " + userLastname;
    }

}
