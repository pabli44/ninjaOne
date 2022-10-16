package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.OrderRepository;
import com.ninjaone.backendinterviewproject.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrderEntity(Order order){
        //duplicated validation
        List<Order> orderList = getOrderEntities().stream()
                                                     .filter(or -> or.getDevices().equals(order.getDevices()) &&
                                                             or.getDeviceItems().equals(order.getDeviceItems()))
                                                             .collect(Collectors.toList());

        if(orderList.size()==0){
            int nextId = getOrderEntities().size()+1;
            order.setId(Long.valueOf(nextId));
            return orderRepository.save(order);
        }

        return null;
    }

    public void deleteOrderEntity(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrderEntities(){
        return orderRepository.findAll();
    }

}
