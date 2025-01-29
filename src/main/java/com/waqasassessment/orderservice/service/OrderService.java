package com.waqasassessment.orderservice.service;

import com.waqasassessment.orderservice.model.OrderEntity;
import com.waqasassessment.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity createOrder(final OrderEntity order) {
        // verify if an item is present in the inventory before creating an order
        final OrderEntity orderSaved = orderRepository.save(order);
        return orderSaved;
    }

    public OrderEntity getOrderById(final String orderId) {
        final long id = Long.parseLong(orderId);
        if(id < 0)
            return null;
        return orderRepository.findById(id).orElse(null);
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
