package com.Capagamini.controller;

import com.Capagamini.entity.Customer;
import com.Capagamini.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    private final ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/consume")
    public String consumeMessages(Customer c) {
        // Call the listener method in the ConsumerService
//        Customer customer = consumerService.listener(new Customer(1, "John Doe", "john@example.com"));
        consumerService.listener(c);
        return "Consumed message: " + c;
    }
}
