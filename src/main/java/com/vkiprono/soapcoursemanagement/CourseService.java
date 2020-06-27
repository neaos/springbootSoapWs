package com.vkiprono.soapcoursemanagement;

import com.vkiprono.courses.Course;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {
    private static final Map<Integer, Course> courses = new HashMap<>();

    @PostConstruct
    public void init() {
        Course course = new Course();
        course.setId(1);
        course.setName("Microservices");
        course.setDepartment("This is the Microservices course");
        course.setDepartment("Computer Science");

        Course course1 = new Course();
        course1.setId(2);
        course1.setName("Springboot");
        course1.setDepartment("This is the Springboot course");
        course1.setDepartment("Computer Science");

        Course course2 = new Course();
        course2.setId(1);
        course2.setName("Accounting");
        course2.setDepartment("Accounting course");
        course2.setDepartment("Finance");

        Course course3 = new Course();
        course3.setId(1);
        course3.setName("Vectors");
        course3.setDepartment("vectors course");
        course3.setDepartment("Engineering");

        courses.put(1, course);
        courses.put(2, course1);
        courses.put(3, course2);
        courses.put(4, course3);

    }

    public Course getCourse(int id) {
        return courses.get(id);
    }

}
