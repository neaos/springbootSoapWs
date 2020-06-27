package com.vkiprono.soapcoursemanagement;

import com.vkiprono.courses.CourseDetailsRequest;
import com.vkiprono.courses.CourseDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {

    private CourseService courseService;

    @Autowired
    public CourseDetailsEndpoint(CourseService courseService) {
        this.courseService = courseService;
    }


    @PayloadRoot(localPart = "CourseDetailsRequest", namespace = "http://vkiprono.com/courses")
    @ResponsePayload
    public CourseDetailsResponse getCourseDetails(@RequestPayload CourseDetailsRequest request) {

        CourseDetailsResponse response = new CourseDetailsResponse();

        response.setCourse(courseService.getCourse(request.getId()));

        return response;
    }
}
