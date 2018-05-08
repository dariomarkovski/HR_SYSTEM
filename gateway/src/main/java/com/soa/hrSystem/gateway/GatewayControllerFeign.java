package com.soa.hrSystem.gateway;

import com.soa.hrSystem.gateway.microservices.ArchiveClient;
import com.soa.hrSystem.gateway.microservices.DevicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayControllerFeign {

    @Autowired
    private DevicesClient devicesClient;

    @Autowired
    private ArchiveClient archiveClient;

    @RequestMapping("/getDevices")
    public String getDevices(){
        return this.devicesClient.getDevices();
    }

    @RequestMapping("/getDeviceCategories")
    public String getDeviceCategories(){
        return this.devicesClient.getDeviceCategories();
    }

    @RequestMapping("/getDocuments")
    public String getDocuments(){
        return archiveClient.getDocuments();
    }

    @RequestMapping("/getHrWorkers")
    public String getHrWorkers(){
        return archiveClient.getHrWorkers();
    }

    @RequestMapping("/getPeople")
    public String getPeople(){
        return archiveClient.getPeople();
    }

}
