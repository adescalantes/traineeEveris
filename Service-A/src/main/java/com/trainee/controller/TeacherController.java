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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * RestController de la clase {@link Teacher} donde se usa el servicio
 * {@link TeacherService}
 * 
 * @author aescalan
 *
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD TeacherController")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  /**
   * Método orientado a obtener una lista de todos los objetos de la clase
   * 
   * @return todos los objetos de la clase
   */
  @GetMapping(value = "/teachers")
  @ApiOperation("Return all Teachers")
  public List<Teacher> getAll() {
    return teacherService.getAll();
  }

  /**
   * Método orientado a traer un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @return el objeto de la clase
   */
  @GetMapping(value = "/teachers/{id}")
  @ApiOperation("Return Teacher by id")
  public Teacher getById(@PathVariable("id") int teacherId) {
//    Teachers parent = teacherService.getById(teacherId);
//    if (parent == null)
//      throw new ControllerNotFoundException("Not found id -" + teacherId);
//    else
    return teacherService.getById(teacherId);
  }

  /**
   * Método orientado a crear un objeto para la clase
   * 
   * @param teacher recibe un objeto de la clase
   * @return la locación donde se creo el objeto con su respectivo status http
   */
  @PostMapping(value = "/teachers")
  @ApiOperation("Create a Teacher")
  public ResponseEntity<Teacher> postTeacher(@RequestBody Teacher teacher) {
    Teacher p = teacherService.post(teacher);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  /**
   * Método orientado a actualizar un objeto por id de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param teacher   recibe un objeto de la clase
   */
  @PutMapping(value = "/teachers/{id}")
  @ApiOperation("Update a Teacher by id")
  public void putTeacher(@PathVariable("id") int teacherId, @RequestBody Teacher teacher) {
    teacherService.putById(teacherId, teacher);
  }

  /**
   * Método orientado a actualizar 1 o más campos de un objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   * @param fields    recibe los campos del objeto
   * @return un status http OK
   */
  @PatchMapping(value = "/teachers/{id}")
  @ApiOperation("Patch a Teacher by id")
  public ResponseEntity<Teacher> patchTeacher(@PathVariable("id") int teacherId,
      @RequestBody Map<String, Object> fields) {
    teacherService.patchById(teacherId, fields);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Método orientado a eliminar 1 objeto de la clase
   * 
   * @param teacherId recibe un id del objeto
   */
  @DeleteMapping(value = "/teachers/{id}")
  @ApiOperation("Delete a Teacher")
  public void deleteTeacher(@PathVariable("id") int teacherId) {
//    Teachers teacher = teacherService.getById(teacherId);
//    if (teacher == null)
//      throw new ControllerNotFoundException("Not found id -" + parentId);
//    else
    teacherService.delete(teacherId);
  }
}
