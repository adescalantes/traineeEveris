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
import com.trainee.models.Family;
import com.trainee.models.projections.FamilyExcerpt;
import com.trainee.services.IFamilyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de Family
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD Family")
public class FamilyController {

  @Autowired
  private IFamilyService familyService;

  /**
   * Método GET para obtener todos los objetos de la clase Family
   * 
   * @return Todos los objetos de la clase Family almacenadas
   */
  @ApiOperation("Return all Families")
  @GetMapping("/families")
  public List<Family> getAll() {
    return familyService.getAll();
  }

  @GetMapping(value = "/families/{id}")
  @ApiOperation("Get Family by id")
  public Family getById(@PathVariable("id") int familyId) {
    Family family = familyService.findOne(familyId);
    if (family == null)
      throw new ControllerNotFoundException("Not found id -" + familyId);
    else
      return familyService.getById(familyId);
  }

  /**
   * Método GET para obtener todos los objetos de la clase FamilyMembers por un
   * parámetro FamilyId
   * 
   * @param id Id de Family que queremos obtener
   * @return FamilyMembers
   */
  @ApiOperation("Return all Families by FamilyId")
  @GetMapping("/families/members/{id}")
  public List<FamilyExcerpt> getFamily(@PathVariable("id") int familyId) {
    return familyService.getFamilyMembers(familyId);
  }

  /**
   * Método POST para guardar un objeto de la clase Family
   * 
   * @param family Ingresamos los datos del objeto Family que deseamos agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new Family")
  @PostMapping("/families")
  public ResponseEntity<Family> postFamily(@Valid @RequestBody Family family) {
    Family f = familyService.post(family);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(f.getId()).toUri();
    return ResponseEntity.created(location).build();

  }

  /**
   * Método PUT para actualizar un objeto de la clase Family
   * 
   * @param family Ingresamos los datos del objeto Family que deseamos actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a Family")
  @PutMapping("/families/{id}")
  public void putFamily(@PathVariable("id") int familyId, @RequestBody @Valid Family family) {
    familyService.putById(familyId, family);
  }

  /**
   * Método DELETE para eliminar un objeto de la clase Family
   * 
   * @param id Id del objeto Family que deseamos eliminar
   */
  @ApiOperation("Delete a Family")
  @DeleteMapping(value = "/families/{id}")
  public void deleteFamily(@PathVariable("id") int familyId) {
    Family family = familyService.findOne(familyId);
    if (family == null)
      throw new ControllerNotFoundException("Not found id -" + familyId);
    else
      familyService.delete(familyId);
  }
}
