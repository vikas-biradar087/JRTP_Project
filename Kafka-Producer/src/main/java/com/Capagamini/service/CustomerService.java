package com.Capagamini.service;

import com.Capagamini.entity.Customer;
import com.Capagamini.entity.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private KafkaTemplate<String,Customer> kafkaTemplate;

    public String add(List<Customer> customers){

        if ((!customers.isEmpty())){

            for(Customer c:customers){
                kafkaTemplate.send(KafkaConstants.TOPIC,c);
                System.out.println("Msg Published to the kafka topic");
            }
        }
        return "Customer record added to kafka queue successfully";
    }
}
