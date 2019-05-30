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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * RestController de la clase {@link Subject} donde se usa el servicio
 * {@link SubjectService}
 * 
 * @author aescalan
 *
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD SubjectController")
public class SubjectController {

  @Autowired
  SubjectService subjectService;

  /**
   * Método orientado a obtener una lista de todos los objetos de la clase
   * 
   * @return todos los objetos de la clase
   */
  @GetMapping(value = "/subjects")
  @ApiOperation("Return all Subjects")
  public List<Subject> getAll() {
    return subjectService.getAll();
  }

  /**
   * Método orientado a traer un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @return el objeto de la clase
   */
  @GetMapping(value = "/subjects/{id}")
  @ApiOperation("Return Subject by id")
  public Subject getById(@PathVariable("id") int subjectId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return subjectService.getById(subjectId);
  }

  /**
   * Método orientado a crear un objeto para la clase
   * 
   * @param teacher recibe un objeto de la clase
   * @return la locación donde se creo el objeto con su respectivo status http
   */
  @PostMapping(value = "/subjects")
  @ApiOperation("Create a Subject")
  public ResponseEntity<Subject> postSubject(@RequestBody Subject subject) {
    Subject p = subjectService.post(subject);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  /**
   * Método orientado a actualizar un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param teacher   recibe un objeto de la clase
   */
  @PutMapping(value = "/subjects/{id}")
  @ApiOperation("Update a Subject by id")
  public void putSubject(@PathVariable("id") int subjectId, @RequestBody @Valid Subject subject) {
    subjectService.putById(subjectId, subject);
  }

  /**
   * Método orientado a actualizar 1 o más campos de un objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param fields    recibe los campos del objeto
   * @return un status http OK
   */
  @PatchMapping(value = "/subjects/{id}")
  @ApiOperation("Patch a Subject by id")
  public ResponseEntity<Subject> patchTeacher(@PathVariable("id") int subjectId,
      @RequestBody Map<String, Object> fields) {
    subjectService.patchById(subjectId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar 1 objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   */
  @DeleteMapping(value = "/subjects/{id}")
  @ApiOperation("Delete a Subject")
  public void deleteSubject(@PathVariable("id") int subjectId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    subjectService.delete(subjectId);
  }
}
