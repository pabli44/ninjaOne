package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DeviceControllerTest {

    private static final String ANTIVIRUS = "Antivitus";
    private static final String SO = "WINDOWS";
    @InjectMocks
    private DeviceService deviceService;

    @Mock
    private DeviceRepository deviceRepository;


    private Device device;


    public DeviceControllerTest(){}

    @BeforeEach
    public void setup(){
        deviceRepository = Mockito.mock(DeviceRepository.class);
        deviceService = new DeviceService(deviceRepository);
        device = new Device();
    }


    @Test
    public void save(){
        device.setId(1L);
        device.setSystemName(SO);
        device.setType(ANTIVIRUS);

        deviceService.saveDeviceEntity(device);
        assertNotNull(device.getId());
    }

}