package com.zero.spring.statemachine.controller;

import com.zero.spring.statemachine.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/statemachine")
public class StateMachineController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/testOrderStatusChange")
    public String testOrderStatusChange(){
        orderService.create();
        orderService.create();
        orderService.pay(1L);
        orderService.deliver(1L);
        orderService.receive(1L);
        orderService.pay(2L);
        orderService.deliver(2L);
        orderService.receive(2L);
        System.out.println("all orders：" + orderService.getOrders());
        return "success";
    }

}