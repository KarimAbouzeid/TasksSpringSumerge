package org.example.services;


import org.example.exception.CourseNotFoundException;
import org.example.dtos.CourseDto;
import org.example.mapper.CourseMapper;
import org.example.repository.CourseRepository;
import org.example.repository.CourseRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.example.entities.Course;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
@ComponentScan({"org.example.repository", "org.example.persistence.mapstruct"})
public class CourseService {
    private final CourseRepositoryJDBC courseRepositoryJDBC;
    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepositoryJDBC courseRepositoryJDBC, CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepositoryJDBC = courseRepositoryJDBC;
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseDto viewCourse(int id) {

        if(courseRepository.findById(id).isEmpty()){
            throw new CourseNotFoundException("Course not found");
        }
        Course course = courseRepository.findById(id).get();
        return courseMapper.courseToCourseDto(course);
    }

    public CourseDto addCourse(CourseDto courseDto){
        Course course = courseMapper.courseDtoToCourse(courseDto);
        Course returnedCourse = courseRepository.save(course);
        return courseMapper.courseToCourseDto(returnedCourse);
    }

    public CourseDto updateCourse(int id, CourseDto courseDto){

        if(courseRepository.findById(id).isEmpty()){
            throw new CourseNotFoundException("Course not found");
        }
        Course course = courseRepository.findById(id).get();
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setCredits(courseDto.getCredits());
        Course c2 = courseRepository.save(course);
        return courseMapper.courseToCourseDto(c2);

    }

    public void updateCourseJDBC(int id, CourseDto courseDto){
        courseRepositoryJDBC.updateCourse(id, courseDto);

    }

    public void deleteCourse(int id) {
        if(courseRepository.findById(id).isEmpty()){
            throw new CourseNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
    }

    public Page<CourseDto> viewAllCourses(Pageable pageable) {

        return courseRepository
                .findAll(pageable)
                .map(courseMapper::courseToCourseDto);

    }
}
