package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findAll();
}
