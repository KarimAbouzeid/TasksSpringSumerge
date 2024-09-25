package org.example.services.impl;



import org.example.Course;
import org.example.CourseRecommender;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;

import java.util.Arrays;
import java.util.List;

@Component
@ComponentScan(basePackages = {"org.example.project2"})
public class CourseRecommenderImpl1 implements CourseRecommender {

    public List<Course> recommendedCourses(){
        Course c1 = new Course(1, "Science", "Science Course", 5);
        Course c2 = new Course(2, "Physics", "Physics Course", 3);
        Course[] arr = {c1, c2};
        return Arrays.asList(arr);
    }
}
