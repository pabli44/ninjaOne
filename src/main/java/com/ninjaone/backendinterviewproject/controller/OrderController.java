package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Orders;
import com.ninjaone.backendinterviewproject.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Order Controller
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Description: save order
     * @param order
     * @return
     */
    @PostMapping
    private Orders postOrderEntity(@RequestBody Orders order){
        if(orderService.saveOrderEntity(order)!=null){
            return new ResponseEntity<Orders>(order, HttpStatus.OK).getBody();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Order was registered before!");
        }
    }

    /**
     * Description: Delete order by id
     * @param id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteOrderEntity(@PathVariable Long id){
        orderService.deleteOrderEntity(id);
    }

    /**
     * Description: Calculate the total cost of the order
     * @param id
     * @return
     */
    @GetMapping("/calculate/{id}")
    private String calculate(@PathVariable Long id){
        return "The Total Cost is: "+orderService.calculate(id);
    }

    /**
     * Description: get all orders
     * @return
     */
    @GetMapping
    private List<Orders> getOrderEntities(){
        return orderService.getOrderEntities();
    }}
