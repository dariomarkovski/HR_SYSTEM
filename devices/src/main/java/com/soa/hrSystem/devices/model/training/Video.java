package com.soa.hrSystem.devices.model.training;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "Video")
public class Video {
    @Id
    @GeneratedValue
    private long id;
    @JoinColumn(nullable = false)
    private String name;
    @JoinColumn(nullable = false)
    private URL url;
    @JoinColumn(nullable = false)
    private String description;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Category category;

    @JoinColumn
    @ManyToOne
    private Course course;

    public Video(long id, String name, URL url, String description, String[] tags) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public Video() {

    }
    public URL getUrl() {

        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
