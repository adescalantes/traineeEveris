package com.trainee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.trainee.resource.StudentFeignResource;

@RestController
public class StudentFeignController {

  @Autowired
  StudentFeignResource studentFeignResource;

  @PostMapping("/v1/students/")
  @HystrixCommand(fallbackMethod = "fallback_student", commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
  public List<Object> getAllStudentsById(@RequestBody List<Integer> ids) {
    return studentFeignResource.getStudentsById(ids);
  }

  public List<Object> fallback_student(@RequestBody List<Integer> ids) {
    List<Object> error = new ArrayList<Object>();
    error.add("El servidor esta caído");
    return error;
  }
}
