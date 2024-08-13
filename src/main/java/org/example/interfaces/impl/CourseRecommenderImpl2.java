package org.example.interfaces.impl;

import org.example.interfaces.CourseRecommender;
import org.example.model.Course;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;



public class CourseRecommenderImpl2 implements CourseRecommender {

    public List<Course> recommendedCourses(){
        Course c1 = new Course(1, "Chemistry", "Chem Course");
        Course c2 = new Course(2, "Maths", "Maths Course");
        Course[] arr = {c1, c2};
        return Arrays.asList(arr);
    }

}
