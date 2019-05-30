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
import com.trainee.models.FamilyMember;
import com.trainee.services.IFamilyMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Clase para manejar el RestController de la clase FamilyMember
 * 
 * @author aescalan
 * @version 1.0
 */
@RestController
@RequestMapping("/v1")
@Api(tags = "CRUD FamilyMember")
public class FamilyMemberController {

  @Autowired
  private IFamilyMemberService familyMemberService;

  /**
   * Método GET para obtener todos los objetos de la clase FamilyMembers
   * 
   * @return todos los objetos de la clase FamilyMembers almacenados
   */
  @ApiOperation("Return all FamilyMembers")
  @GetMapping("/familyMembers")
  public List<FamilyMember> getAll() {
    return familyMemberService.getAll();
  }

  @GetMapping(value = "/familyMembers/{id}")
  @ApiOperation("Get FamilyMember by id")
  public FamilyMember getById(@PathVariable("id") int familyMemberId) {
    FamilyMember familyMember = familyMemberService.findOne(familyMemberId);
    if (familyMember == null)
      throw new ControllerNotFoundException("Not found id -" + familyMemberId);
    else
      return familyMemberService.getById(familyMemberId);
  }

  /**
   * Método POST para guardar un objeto de la clase FamilyMember
   * 
   * @param familyMember Ingresamos los datos del objeto FamilyMember que deseamos
   *                     agregar
   * @return Manejo de HttpStatus(201 Si se creo ó 400 si algo falló)
   */
  @ApiOperation("Create a new FamilyMember")
  @PostMapping("/familyMembers")
  public ResponseEntity<FamilyMember> postFamilyMember(@RequestBody @Valid FamilyMember familyMember) {
    FamilyMember fm = familyMemberService.post(familyMember);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fm.getId()).toUri();
    return ResponseEntity.created(location).build();

  }

  /**
   * Método PUT para actualizar un objeto de la clase FamilyMember
   * 
   * @param familyMember Ingresamos los datos del objeto FamilyMember que deseamos
   *                     actualizar
   * @return Manejo de HttpStatus(202 Si se actualizó ó 404 si algo falló)
   */
  @ApiOperation("Update a FamilyMember")
  @PutMapping("/familyMembers/{id}")
  public void putFamilyMember(@PathVariable("id") int familyMemberId, @RequestBody @Valid FamilyMember familyMember) {
    familyMemberService.putById(familyMemberId, familyMember);
  }

  /**
   * Método DELETE para eliminar un objeto de la clase FamilyMember
   * 
   * @param id Id del objeto FamilyMember que deseamos eliminar
   */
  @ApiOperation("Delete a FamilyMember")
  @DeleteMapping(value = "/familyMembers/{id}")
  public void deleteParents(@PathVariable("id") int familyMemberId) {
    FamilyMember familyMember = familyMemberService.findOne(familyMemberId);
    if (familyMember == null)
      throw new ControllerNotFoundException("Not found id -" + familyMemberId);
    else
      familyMemberService.delete(familyMemberId);
  }

}
