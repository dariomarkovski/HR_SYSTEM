package com.soa.hrSystem.archive.service;

import com.soa.hrSystem.archive.model.Person;
import com.soa.hrSystem.archive.model.archive.exceptions.PersonNotFoundException;

public interface PersonService {

    Person save(Person person);
    Person getById(Long id) throws PersonNotFoundException;
    void delete(Long id);
    Iterable<Person> getAllPersons();

}
