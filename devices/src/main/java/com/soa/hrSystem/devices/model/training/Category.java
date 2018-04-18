package com.soa.hrSystem.devices.model.training;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = true)
    private String name;
    @Column(nullable = true)
    private String description;

    @OneToMany (mappedBy = "category")
    private List<Video> videos;

    @OneToMany (mappedBy = "category")
    private List<Course> courses;

    public Category() {

    }

    public Category(String name, String description, List<Video> videos, List<Course> courses) {
        this.name = name;
        this.description = description;
        this.videos = videos;
        this.courses = courses;
    }

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
