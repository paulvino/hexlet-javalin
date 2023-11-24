package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public final class Course {
    private Long id;

    @ToString.Include
    private String name;
    private String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(Map<String, Object> courseMap) {
        this.name = courseMap.get("name").toString();
        this.description = courseMap.get("description").toString();
    }
}
