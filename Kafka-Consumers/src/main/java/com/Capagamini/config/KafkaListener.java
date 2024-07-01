package com.Capagamini.config;

import com.Capagamini.entity.Customer;
import com.Capagamini.entity.KafkaConstants;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaListener {

    @Bean
    public ConsumerFactory<String, Customer> consumerFactory(){

        Map<String,Object> pro=new HashMap<>();

        pro.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
        pro.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstants .GROUP_ID);
        pro.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        pro.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerialize.class);

       return new DefaultKafkaConsumerFactory<>(pro, new StringDeserializer(), new JsonDeserializer<>(Customer.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Customer> kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String,Customer> factory=new ConcurrentKafkaListenerContainerFactory<String, Customer>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }


}
