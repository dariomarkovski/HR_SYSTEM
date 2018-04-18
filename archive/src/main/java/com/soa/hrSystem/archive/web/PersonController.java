package com.soa.hrSystem.archive.web;

import com.soa.hrSystem.archive.model.Person;
import com.soa.hrSystem.archive.model.archive.exceptions.PersonNotFoundException;
import com.soa.hrSystem.archive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    Person addNewPerson(@ModelAttribute Person person){
        return this.personService.save(person);
    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") Long id){
        this.personService.delete(id);
    }

    @GetMapping
    Iterable<Person> getAllPersons(){
        return this.personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    Person findById(@PathVariable("id") Long id) throws PersonNotFoundException {
        return this.personService.getById(id);
    }
}
