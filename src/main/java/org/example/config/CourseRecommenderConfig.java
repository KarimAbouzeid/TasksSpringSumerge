package org.example.config;

import org.example.interfaces.CourseRecommender;
import org.example.interfaces.impl.CourseRecommenderImpl1;
import org.example.interfaces.impl.CourseRecommenderImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CourseRecommenderConfig {

    @Bean(name = "primaryRecommender")
    @Primary
    public CourseRecommender primaryRecommender() {
        return new CourseRecommenderImpl1();
    }

    @Bean(name = "secondaryRecommender")
    public CourseRecommender secondaryRecommender() {
        return new CourseRecommenderImpl2();
    }
}
