package com.soa.hrSystem.devices.web;

import com.soa.hrSystem.devices.model.devices.Device;
import com.soa.hrSystem.devices.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/devices")
@CrossOrigin
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping(value = "/getAllDevices")
    public Iterable<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping(value = "/getDeviceById")
    public Device getDeviceById(@RequestParam long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping(value = "/addNewDevice")
    public Device addNewDevice(@ModelAttribute Device newDevice) {
        return deviceService.addNewDevice(newDevice);
    }

    @PostMapping(value = "/deleteDeviceById")
    public long deleteDeviceById(long id) {
        return deviceService.deleteDeviceById(id);
    }


}
