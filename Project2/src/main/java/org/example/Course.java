package org.example;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@Data
public class Course {

    private int id;
    private String name;
    private String description;
    private int credits;


    public Course(int id, String name, String description, int credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Course(){

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && credits == course.credits && Objects.equals(name, course.name) && Objects.equals(description, course.description);
    }

}
