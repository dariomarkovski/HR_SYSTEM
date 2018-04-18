package com.soa.hrSystem.devices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soa.hrSystem.devices.model.archive.Document;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String EMBG;

    @OneToMany(mappedBy = "signatures")
    @JsonIgnore
    private Set<Document> documents;

    public Person() {

    }

    public Person(String firstName, String lastName, String EMBG) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.EMBG = EMBG;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName,lastName,EMBG);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMBG() {
        return EMBG;
    }

    public void setEMBG(String EMBG) {
        this.EMBG = EMBG;
    }
}
