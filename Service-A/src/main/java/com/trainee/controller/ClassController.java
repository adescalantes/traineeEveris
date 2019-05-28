package com.trainee.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.trainee.model.ClassModel;
import com.trainee.service.ClassService;

@RestController
@RequestMapping("/v1")
public class ClassController {

  @Autowired
  ClassService classService;

  @GetMapping(value = "/classes")
  public List<ClassModel> getAll() {
    return classService.getAll();
  }

  @GetMapping(value = "/classes/{id}")
  public ClassModel getById(@PathVariable("id") int classesId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return classService.getById(classesId);
  }

  @PostMapping(value = "/classes")
  public ResponseEntity<ClassModel> postSubject(@RequestBody @Valid ClassModel classes) {
    ClassModel p = classService.post(classes);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = "/classes/{id}")
  public void putSubject(@PathVariable("id") int classesId, @RequestBody @Valid ClassModel classes) {
    classService.putById(classesId, classes);
  }

  @PatchMapping(value = "/classes/{id}")
  public ResponseEntity<ClassModel> patchClaim(@PathVariable("id") int classesId,
      @RequestBody Map<String, Object> fields) {
    classService.patchById(classesId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/classes/{id}")
  public void deleteSubject(@PathVariable("id") int classesId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    classService.delete(classesId);
  }
}
