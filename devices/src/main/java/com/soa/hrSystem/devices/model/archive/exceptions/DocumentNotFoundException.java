package com.soa.hrSystem.devices.model.archive.exceptions;

public class DocumentNotFoundException extends Exception{

    public DocumentNotFoundException(Long id) {
        super(String.format("Document with id: %d not found", id));
    }

}
