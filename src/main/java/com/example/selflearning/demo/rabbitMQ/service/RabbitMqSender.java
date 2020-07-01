package com.example.selflearning.demo.rabbitMQ.service;

import com.example.selflearning.demo.rabbitMQ.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    @Scheduled(fixedRate = 3000L)
    public void send(Employee company) {
        rabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
