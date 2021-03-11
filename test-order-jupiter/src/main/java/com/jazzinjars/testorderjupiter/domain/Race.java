package com.jazzinjars.testorderjupiter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Race {
    @Id
    private long id;
    private String name;

    protected Race() {}

    public Race(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
