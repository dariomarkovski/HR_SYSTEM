package com.soa.hrSystem.vacations.model.archive;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "HrPersonal")
public class HrWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;

    String firstName;
    String lastName;
    String EMBG;

    @OneToMany(mappedBy = "signaturesFromHR")
    private Set<Document> contractsSigned;

    public HrWorker() {

    }

    public HrWorker(String firstName, String lastName, String EMBG) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.EMBG = EMBG;
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
