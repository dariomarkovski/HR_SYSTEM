package com.soa.hrSystem.archive.model.archive.exceptions;

public class HrWorkerNotFoundException extends Exception{

    public HrWorkerNotFoundException(Long id) {
        super(String.format("HrWorker with id: %d not found", id));
    }

}
