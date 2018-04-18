package com.soa.hrSystem.devices.persistence;

import com.soa.hrSystem.devices.model.devices.DeviceCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceCategoryDao extends CrudRepository<DeviceCategory, Long> {
    DeviceCategory findById(long id);
}
