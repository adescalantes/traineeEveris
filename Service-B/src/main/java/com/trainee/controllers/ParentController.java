package com.trainee.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trainee.exceptions.ControllerNotFoundException;
import com.trainee.models.Parent;
import com.trainee.services.IParentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de la clase Parent
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD Parent")
public class ParentController {

  @Autowired
  private IParentService parentService;

  /**
   * Método GET para obtener todos los objetos de la clase Parents
   * 
   * @return Todos los objetos de la clase Parents almacenados
   */
  @ApiOperation("Return all Parents")
  @GetMapping(value = "/parents")
  public List<Parent> getAll() {
    return parentService.getAll();
  }

  @GetMapping(value = "/parents/{id}")
  @ApiOperation("Get Parent by id")
  public Parent getById(@PathVariable("id") int parentId) {
    Parent parent = parentService.findOne(parentId);
    if (parent == null)
      throw new ControllerNotFoundException("Not found id -" + parentId);
    else
      return parentService.getById(parentId);
  }

  /**
   * Método POST para guardar un objeto de la clase Parent
   * 
   * @param parent Ingresamos los datos del Parent que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new Parent")
  @PostMapping(value = "/parents")
  public ResponseEntity<Parent> postParent(@RequestBody @Valid Parent parent) {
    Parent p = parentService.post(parent);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  /**
   * Método PUT para actualizar un objeto de la clase Parent
   * 
   * @param parent Ingresamos los datos del objeto Parent que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a Parent")
  @PutMapping(value = "/parents/{id}")
  public void putParent(@PathVariable("id") int parentId, @RequestBody @Valid Parent parent) {
    parentService.putById(parentId, parent);
  }

  /**
   * Método DELETE para eliminar un objeto de la clase Parent
   * 
   * @param id Id del Parent que deseamos eliminar
   */
  @ApiOperation("Delete a Parent")
  @DeleteMapping(value = "/parents/{id}")
  public void deleteParent(@PathVariable("id") int parentId) {
    Parent parent = parentService.findOne(parentId);
    if (parent == null)
      throw new ControllerNotFoundException("Not found id -" + parentId);
    else
      parentService.delete(parentId);
  }
}
