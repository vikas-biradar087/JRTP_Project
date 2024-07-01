package com.Capagamini.controller;

import com.Capagamini.entity.Customer;
import com.Capagamini.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class kafkaProduceController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody List<Customer> customers){

        return customerService.add(customers);

    }
}
