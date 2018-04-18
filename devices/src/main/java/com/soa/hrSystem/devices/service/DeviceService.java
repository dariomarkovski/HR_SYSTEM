package com.soa.hrSystem.devices.service;

import com.soa.hrSystem.devices.model.devices.Device;
import com.soa.hrSystem.devices.model.devices.DeviceCategory;

public interface DeviceService {
    Iterable<Device> getAllDevices();

    Device getDeviceById(long id);

    Device addNewDevice(Device newDevice);

    long deleteDeviceById(long id);

    Iterable<Device> getAllDevicesByCategory(DeviceCategory deviceCategory);
}
