package com.soa.hrSystem.archive.model.devices;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DeviceCategory")
public class DeviceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "deviceCategory", cascade = CascadeType.ALL)
    private Set<Device> deviceSet;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
