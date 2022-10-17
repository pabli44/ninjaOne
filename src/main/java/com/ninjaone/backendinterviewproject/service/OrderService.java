package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.database.OrderRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final DeviceRepository deviceRepository;

    public OrderService(OrderRepository orderRepository, DeviceRepository deviceRepository) {
        this.orderRepository = orderRepository;
        this.deviceRepository = deviceRepository;
    }

    public Orders saveOrderEntity(Orders order){
        //duplicated validation
        List<Orders> orderList = getOrderEntities().stream()
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

    public List<Orders> getOrderEntities(){
        return orderRepository.findAll();
    }

    public double calculate(Long id){
        Optional<Orders> order = orderRepository.findById(id);
        String[] deviceItemsArray = order.get().getDeviceItems().split(",");
        String[] deviceItemSplit = {};
        String deviceId = "";
        String itemQuantity = "";

        double devicesItemsCost = 0;
        List<Device> deviceList = deviceRepository.findAll();

        for(int i=0;i<deviceItemsArray.length;i++){
            deviceItemSplit = deviceItemsArray[i].split("-");
            deviceId = deviceItemSplit[0];
            itemQuantity = deviceItemSplit[1];
            devicesItemsCost += deviceList.get(Integer.parseInt(deviceId)-1).getPrice() * Integer.parseInt(itemQuantity);

        }

        return devicesItemsCost+order.get().getDevices()*4;
    }

}
