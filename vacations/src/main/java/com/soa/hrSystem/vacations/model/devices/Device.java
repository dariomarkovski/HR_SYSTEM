package com.soa.hrSystem.vacations.model.devices;


import com.soa.hrSystem.vacations.model.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Device")
public class Device {

    public enum DeviceType {
        EMPLOYEE_DEVICE, TEST_DEVICE, OTHER_DEVICE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private boolean retired;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JoinColumn(nullable = false)
    @ManyToOne
    private DeviceCategory deviceCategory;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @Column(nullable = false)
    private boolean available;

    @JoinColumn(nullable = true)
    @ManyToOne
    private Employee userOfDevice;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<Issue> issueSet;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }


}
