package com.soa.hrSystem.devices.service.Impl;

import com.soa.hrSystem.devices.model.devices.DeviceCategory;
import com.soa.hrSystem.devices.persistence.DeviceCategoryDao;
import com.soa.hrSystem.devices.service.DeviceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceCategoryServiceImpl implements DeviceCategoryService {

    @Autowired
    DeviceCategoryDao deviceCategoryDao;

    @Override
    public Iterable<DeviceCategory> getAllDeviceCategories() {
        return deviceCategoryDao.findAll();
    }

    @Override
    public DeviceCategory getDeviceCategoryById(long id) {
        return deviceCategoryDao.findById(id);
    }

    @Override
    public DeviceCategory addNewDeviceCategory(DeviceCategory deviceCategory) {
        return deviceCategoryDao.save(deviceCategory);
    }
}
