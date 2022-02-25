package com.sha.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
                value = "course-service", //name of course-service application
                path = "/api/course", //pre-path of course-service
                url = "${course.service.url}",
                configuration = FeignConfiguration.class
            )
public interface CourseServiceRequest {
    @PostMapping // api/course
    Object saveCourse(@RequestBody Object request);

    @DeleteMapping("{courseId}")// api/course/{courseId}
    void deleteCourse(@PathVariable("courseId") Long courseId);

    @GetMapping // api/course
    List<Object> getAllCourses();
}
