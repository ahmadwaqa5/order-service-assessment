package com.waqasassessment.orderservice.service;

import com.waqasassessment.orderservice.model.Order;
import com.waqasassessment.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(final Order order) {
        final Order orderSaved = orderRepository.save(order);
        return orderSaved;
    }

    public Order getOrderById(final String orderId) {
        final long id = Long.parseLong(orderId);
        if(id < 0)
            return null;
        return orderRepository.findById(id).orElse(null);
    }
}
