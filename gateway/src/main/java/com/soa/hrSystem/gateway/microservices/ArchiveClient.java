package com.soa.hrSystem.gateway.microservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("archive")
public interface ArchiveClient {

    @RequestMapping(method = RequestMethod.GET, value = "/documents/")
    String getDocuments();

    @RequestMapping(method = RequestMethod.GET, value = "/hrworker/")
    String getHrWorkers();

    @RequestMapping(method = RequestMethod.GET, value = "/person")
    String getPeople();

}
