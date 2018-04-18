package com.soa.hrSystem.devices.persistence;

import com.soa.hrSystem.devices.model.devices.Device;
import com.soa.hrSystem.devices.model.devices.DeviceCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends CrudRepository<Device, Long> {
    Device findById(long id);

    Iterable<Device> findAllByDeviceCategory(DeviceCategory deviceCategory);

    Long deleteById(long id);
}
