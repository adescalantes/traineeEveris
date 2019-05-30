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
import com.trainee.model.projection.StudentProjection;
import com.trainee.service.ClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * RestController de la clase {@link ClassModel} donde se usa el servicio
 * {@link ClassService}
 * 
 * @author aescalan
 *
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD ClassController")
public class ClassController {

  @Autowired
  ClassService classService;

  @GetMapping(value = "/class/students")
  @ApiOperation("Return all Teachers")
  public List<StudentProjection> getxz() {
    return classService.getAllStudents();
  }

  /**
   * Método orientado a obtener una lista de todos los objetos de la clase
   * 
   * @return todos los objetos de la clase
   */
  @GetMapping(value = "/classes")
  @ApiOperation("Return all Classes")
  public List<ClassModel> getAll() {
    return classService.getAll();
  }

  /**
   * Método orientado a traer un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @return el objeto de la clase
   */
  @GetMapping(value = "/classes/{id}")
  @ApiOperation("Return Class by id")
  public ClassModel getById(@PathVariable("id") int classesId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return classService.getById(classesId);
  }

  /**
   * Método orientado a crear un objeto para la clase
   * 
   * @param teacher recibe un objeto de la clase
   * @return la locación donde se creo el objeto con su respectivo status http
   */
  @PostMapping(value = "/classes")
  @ApiOperation("Create a Class")
  public ResponseEntity<ClassModel> postSubject(@RequestBody ClassModel classes) {
    ClassModel p = classService.post(classes);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  /**
   * Método orientado a actualizar un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param teacher   recibe un objeto de la clase
   */
  @PutMapping(value = "/classes/{id}")
  @ApiOperation("Update a Class by id")
  public void putSubject(@PathVariable("id") int classesId, @RequestBody @Valid ClassModel classes) {
    classService.putById(classesId, classes);
  }

  /**
   * Método orientado a actualizar 1 o más campos de un objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param fields    recibe los campos del objeto
   * @return un status http OK
   */
  @PatchMapping(value = "/classes/{id}")
  @ApiOperation("Patch a Class by id")
  public ResponseEntity<ClassModel> patchClass(@PathVariable("id") int classesId,
      @RequestBody Map<String, Object> fields) {
    classService.patchById(classesId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar 1 objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   */
  @DeleteMapping(value = "/classes/{id}")
  @ApiOperation("Delete a Class")
  public void deleteSubject(@PathVariable("id") int classesId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    classService.delete(classesId);
  }
}
