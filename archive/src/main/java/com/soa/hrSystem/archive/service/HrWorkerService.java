package com.soa.hrSystem.archive.service;

import com.soa.hrSystem.archive.model.archive.HrWorker;
import com.soa.hrSystem.archive.model.archive.exceptions.HrWorkerNotFoundException;

public interface HrWorkerService {

    HrWorker save(HrWorker person);
    HrWorker getById(Long id) throws HrWorkerNotFoundException;
    void delete(Long id);
    Iterable<HrWorker> getAllHrWorkers();


}
