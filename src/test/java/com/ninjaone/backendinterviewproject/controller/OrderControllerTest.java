package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.OrderRepository;
import com.ninjaone.backendinterviewproject.model.Orders;
import com.ninjaone.backendinterviewproject.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderControllerTest {


    private static final String ANTIVIRUS = "Antivitus";
    private static final String SO = "WINDOWS";
    private static final String DEVICE_ITEMS = "1-2,2-3,3-5,5-5";
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private DeviceRepository deviceRepository;


    private Orders order;


    public OrderControllerTest(){}

    @BeforeEach
    public void setup(){
        orderRepository = Mockito.mock(OrderRepository.class);
        deviceRepository = Mockito.mock(DeviceRepository.class);
        orderService = new OrderService(orderRepository, deviceRepository);
        order = new Orders();
    }


    @Test
    public void save(){
        order.setId(1L);
        order.setDevices(5);
        order.setDeviceItems(DEVICE_ITEMS);

        orderService.saveOrderEntity(order);
        assertNotNull(order.getId());
    }

}