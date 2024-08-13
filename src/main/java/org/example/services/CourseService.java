package org.example.services;


import org.example.interfaces.CourseRecommender;
import org.example.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CourseService {
    CourseRecommender courseRecommender;

    @Autowired
    public CourseService(@Qualifier("secondaryRecommender") CourseRecommender courseRecommender) {
        this.courseRecommender = courseRecommender;
    }

    @Autowired
    public void setCourseRecommender(CourseRecommender courseRecommender) {
        this.courseRecommender = courseRecommender;
    }

    List<Course> getRecommendedCourses(){
        return courseRecommender.recommendedCourses();
    }
}
