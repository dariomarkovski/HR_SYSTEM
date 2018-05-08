package com.soa.hrSystem.gateway.microservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("devices")
public interface DevicesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/devices/getAllDevices")
    String getDevices();

    @RequestMapping(method = RequestMethod.GET, value = "/deviceCategories/getAllDeviceCategories")
    String getDeviceCategories();

}
