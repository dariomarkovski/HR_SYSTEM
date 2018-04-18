package com.soa.hrSystem.devices.service.Impl;

import com.soa.hrSystem.devices.model.devices.Device;
import com.soa.hrSystem.devices.model.devices.DeviceCategory;
import com.soa.hrSystem.devices.persistence.DeviceDao;
import com.soa.hrSystem.devices.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;

    @Override
    public Iterable<Device> getAllDevices() {
        return deviceDao.findAll();
    }

    @Override
    public Device getDeviceById(long id) {
        return deviceDao.findById(id);
    }

    @Override
    public Device addNewDevice(Device newDevice) {
        return deviceDao.save(newDevice);
    }

    @Override
    public long deleteDeviceById(long id) {
        return deviceDao.deleteById(id);
    }

    @Override
    public Iterable<Device> getAllDevicesByCategory(DeviceCategory deviceCategory) {
        return deviceDao.findAllByDeviceCategory(deviceCategory);
    }


}
