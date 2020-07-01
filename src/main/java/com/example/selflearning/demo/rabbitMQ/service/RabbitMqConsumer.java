package com.example.selflearning.demo.rabbitMQ.service;

import com.example.selflearning.demo.rabbitMQ.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void recievedMessage(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }
}
