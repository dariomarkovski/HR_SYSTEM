package com.soa.hrSystem.devices.web;

import com.soa.hrSystem.devices.model.devices.DeviceCategory;
import com.soa.hrSystem.devices.service.DeviceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deviceCategories")
@CrossOrigin
public class DeviceCategoryController {

    @Autowired
    DeviceCategoryService deviceCategoryService;

    @GetMapping(value = "/getAllDeviceCategories")
    public Iterable<DeviceCategory> getAllDeviceCategories() {
        return deviceCategoryService.getAllDeviceCategories();
    }

    @GetMapping(value = "/getDeviceCategoryById")
    public DeviceCategory getDeviceCategoryById(@RequestParam long id) {
        return deviceCategoryService.getDeviceCategoryById(id);
    }

    @PostMapping(value = "/addNewDeviceCategory")
    public DeviceCategory addNewDeviceCategory(@ModelAttribute DeviceCategory deviceCategory) {
        return deviceCategoryService.addNewDeviceCategory(deviceCategory);
    }

}
