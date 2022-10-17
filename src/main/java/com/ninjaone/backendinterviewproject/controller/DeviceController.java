package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Device Controller
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }


    /**
     * Description: save device
     * @param device
     * @return
     */
    @PostMapping
    private Device postDeviceEntity(@RequestBody Device device){
        if(deviceService.saveDeviceEntity(device)!=null){
            return new ResponseEntity<Device>(device, HttpStatus.OK).getBody();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Device was registered before!");
        }
    }

    /**
     * Description: get device by id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/{id}")
    private Device getDeviceEntity(@PathVariable Long id) throws Exception {
        return deviceService.getDeviceEntity(id).orElseThrow();
    }

    /**
     * Description: delete device by id
     * @param id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDeviceEntity(@PathVariable Long id){
        deviceService.deleteDeviceEntity(id);
    }

    /**
     * Description: get all devices
     * @return
     */
    @GetMapping
    private List<Device> getDeviceEntities(){
        return deviceService.getDeviceEntities();
    }

    /**
     * Description: Update device
     * @param device
     * @return
     */
    @PutMapping
    private Device updateDevice(@RequestBody Device device){
        return deviceService.updateDevice(device);
    }
}
