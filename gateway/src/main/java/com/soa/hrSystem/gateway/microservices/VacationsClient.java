package com.soa.hrSystem.gateway.microservices;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("vacations")
public interface VacationsClient {



}
