package com.soa.hrSystem.devices.model;

import com.soa.hrSystem.devices.model.devices.Device;
import com.soa.hrSystem.devices.model.vacations.Vacation;
import com.soa.hrSystem.devices.model.vacations.VacationDays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Employee extends Person {

    public Employee() {
    }

    public Employee(String firstName, String lastName, String EMBG) {
        super(firstName, lastName, EMBG);
    }

    // Don't create Getter or Setter
    @OneToMany(mappedBy = "userOfDevice", cascade = CascadeType.ALL)
    private Set<Device> deviceSet;

    @OneToMany(mappedBy = "employee")
    private Set<VacationDays> vacationDaysSet;

    @OneToMany(mappedBy = "employee") 
    private Set<Vacation> vacationsSet;
}
