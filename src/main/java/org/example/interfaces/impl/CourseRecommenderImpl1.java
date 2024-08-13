package org.example.interfaces.impl;

import org.example.interfaces.CourseRecommender;
import org.example.model.Course;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CourseRecommenderImpl1 implements CourseRecommender {

    public List<Course> recommendedCourses(){
        Course c1 = new Course(1, "Science", "Science Course");
        Course c2 = new Course(2, "Physics", "Physics Course");
        Course[] arr = {c1, c2};
        return Arrays.asList(arr);
    }
}
