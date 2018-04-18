package com.soa.hrSystem.archive.model.archive.exceptions;

public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(Long id) {
        super(String.format("Person with id: %d not found", id));
    }
}
