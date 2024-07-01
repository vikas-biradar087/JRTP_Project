package com.Capagamini.service;

import com.Capagamini.entity.Customer;
import com.Capagamini.entity.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = KafkaConstants.TOPIC,groupId = KafkaConstants .GROUP_ID)
    public Customer listener(Customer c){
        System.out.println("message Received From Kafka topic :"+ c);
        return c;
    }
}
