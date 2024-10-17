package com.zero.spring.statemachine.service;

import com.zero.spring.statemachine.common.state.Order;

import java.util.Map;

public interface OrderService {

    Order create();

    Order pay(long id);

    Order deliver(long id);

    Order receive(long id);

    Map<Long, Order> getOrders();
}
