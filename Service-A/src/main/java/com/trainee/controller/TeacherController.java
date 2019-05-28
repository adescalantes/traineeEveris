package com.trainee.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trainee.model.Teacher;
import com.trainee.service.TeacherService;

@RestController
@RequestMapping("/v1")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  @GetMapping(value = "/teachers")
  public List<Teacher> getAll() {
    return teacherService.getAll();
  }

  @GetMapping(value = "/teachers/{id}")
  public Teacher getById(@PathVariable("id") int teacherId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return teacherService.getById(teacherId);
  }

  @PostMapping(value = "/teachers")
  public ResponseEntity<Teacher> postTeacher(@RequestBody Teacher teacher) {
    Teacher p = teacherService.post(teacher);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = "/teachers/{id}")
  public void putTeacher(@PathVariable("id") int teacherId, @RequestBody Teacher teacher) {
    teacherService.putById(teacherId, teacher);
  }

  @PatchMapping(value = "/teachers/{id}")
  public ResponseEntity<Teacher> patchClaim(@PathVariable("id") int teacherId,
      @RequestBody Map<String, Object> fields) {
    teacherService.patchById(teacherId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/teachers/{id}")
  public void deleteTeacher(@PathVariable("id") int teacherId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    teacherService.delete(teacherId);
  }
}
