package com.example.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
  
  @RequestMapping("/courses")
  public List<Course> getCourses() {
    return Arrays.asList(
      new Course(1,"Learn AWS", "udemy"),
      new Course(2,"Learn Devops", "udemy"),
      new Course(3,"Learn Azure", "udemy")
    );
  }
}
