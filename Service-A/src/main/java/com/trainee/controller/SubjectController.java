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

import com.trainee.model.Subject;
import com.trainee.service.SubjectService;

@RestController
@RequestMapping("/v1")
public class SubjectController {

  @Autowired
  SubjectService subjectService;

  @GetMapping(value = "/subjects")
  public List<Subject> getAll() {
    return subjectService.getAll();
  }

  @GetMapping(value = "/subjects/{id}")
  public Subject getById(@PathVariable("id") int subjectId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return subjectService.getById(subjectId);
  }

  @PostMapping(value = "/subjects")
  public ResponseEntity<Subject> postSubject(@RequestBody @Valid Subject subject) {
    Subject p = subjectService.post(subject);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping(value = "/subjects/{id}")
  public void putSubject(@PathVariable("id") int subjectId, @RequestBody @Valid Subject subject) {
    subjectService.putById(subjectId, subject);
  }

  @PatchMapping(value = "/subjects/{id}")
  public ResponseEntity<Subject> patchClaim(@PathVariable("id") int subjectId,
      @RequestBody Map<String, Object> fields) {
    subjectService.patchById(subjectId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/subjects/{id}")
  public void deleteSubject(@PathVariable("id") int subjectId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    subjectService.delete(subjectId);
  }
}
