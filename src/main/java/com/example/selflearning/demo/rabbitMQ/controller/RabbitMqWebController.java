package com.example.selflearning.demo.rabbitMQ.controller;

import com.example.selflearning.demo.rabbitMQ.model.Employee;
import com.example.selflearning.demo.rabbitMQ.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitMqWebController {
    @Autowired
    RabbitMqSender rabbitMQSender;

    @GetMapping(value = "/send")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
//    public String producer(){
        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQSender.send(emp);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
