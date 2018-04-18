package com.soa.hrSystem.archive.persistence.person;

import com.soa.hrSystem.archive.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
