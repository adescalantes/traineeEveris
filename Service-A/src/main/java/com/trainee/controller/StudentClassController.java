package com.trainee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.model.StudentClass;
import com.trainee.service.StudentClassService;

@RestController
@RequestMapping("/v1")
public class StudentClassController {

  @Autowired
  StudentClassService studentClassService;

  @GetMapping(value = "/studentClasses")
  public List<StudentClass> getAll() {
    return studentClassService.getAll();
  }

  @PostMapping(value = "/studentClasses")
  public void postSubject(@RequestBody @Valid StudentClass studentClasses) {
    studentClassService.post(studentClasses);

  }
}
