package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device saveDeviceEntity(Device device){
        //duplicated validation
        List<Device> deviceList = getDeviceEntities().stream()
                                                     .filter(de -> de.getType().equals(device.getType()) &&
                                                                   de.getSystemName().equals(device.getSystemName()) &&
                                                                   de.getPrice() == device.getPrice())
                                                     .collect(Collectors.toList());

        if(deviceList.size()==0){
            int nextId = getDeviceEntities().size()+1;
            device.setId(Long.valueOf(nextId));
            return deviceRepository.save(device);
        }

        return null;
    }

    public Optional<Device> getDeviceEntity(Long id){
        return deviceRepository.findById(id);
    }
    public void deleteDeviceEntity(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<Device> getDeviceEntities(){
        return deviceRepository.findAll();
    }

    public Device updateDevice(Device device){
        Optional<Device> deviceToUpdate = deviceRepository.findById(device.getId());
        Optional.ofNullable(deviceToUpdate)
                .map(du -> deviceRepository.save(device))
                .orElseThrow();

        return device;
    }
}
