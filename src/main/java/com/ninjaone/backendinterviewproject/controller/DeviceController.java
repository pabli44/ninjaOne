package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    @PostMapping
    private Device postDeviceEntity(@RequestBody Device device){
        if(deviceService.saveDeviceEntity(device)!=null){
            return new ResponseEntity<Device>(device, HttpStatus.OK).getBody();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Device was registered before!");
        }
    }

    @GetMapping("/{id}")
    private Device getDeviceEntity(@PathVariable Long id) throws Exception {
        return deviceService.getDeviceEntity(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDeviceEntity(@PathVariable Long id){
        deviceService.deleteDeviceEntity(id);
    }

    @GetMapping
    private List<Device> getDeviceEntities(){
        return deviceService.getDeviceEntities();
    }

    @PutMapping
    private Device updateDevice(@RequestBody Device device){
        return deviceService.updateDevice(device);
    }
}
