package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Order;
import com.ninjaone.backendinterviewproject.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    private Order postOrderEntity(@RequestBody Order order){
        if(orderService.saveOrderEntity(order)!=null){
            return new ResponseEntity<Order>(order, HttpStatus.OK).getBody();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Order was registered before!");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteOrderEntity(@PathVariable Long id){
        orderService.deleteOrderEntity(id);
    }

    private Double calculate(@PathVariable Long id){


        return 0d;
    }
}
