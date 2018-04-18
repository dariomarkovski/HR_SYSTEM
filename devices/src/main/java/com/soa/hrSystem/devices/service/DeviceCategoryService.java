package com.soa.hrSystem.devices.service;

import com.soa.hrSystem.devices.model.devices.DeviceCategory;

public interface DeviceCategoryService {
    Iterable<DeviceCategory> getAllDeviceCategories();

    DeviceCategory getDeviceCategoryById(long id);

    DeviceCategory addNewDeviceCategory(DeviceCategory deviceCategory);
}
