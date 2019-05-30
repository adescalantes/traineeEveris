package com.trainee.services.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.Family;
import com.trainee.models.projections.FamilyExcerpt;
import com.trainee.repositories.FamilyMemberRepository;
import com.trainee.repositories.FamilyRepository;
import com.trainee.services.IFamilyService;

/**
 * Clase donde se realizá la lógica de la clase Family para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class FamilyServiceImpl implements IFamilyService {
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private FamilyMemberRepository familyMemberRepository;

  /**
   * Método para obtener todos los objetos de la clase Family
   * 
   * @return Todos los objetos de la clase FamilyMember
   */
  @Override
  public List<Family> getAll() {
    log.info("Getting All Families");
    return (List<Family>) familyRepository.findAll();
  }

  @Override
  public Family getById(int familyId) {
    return familyRepository.findById(familyId);
  }

  /**
   * Método para obtener todos los objetos de la clase FamilyMembers por un
   * FamilyId
   * 
   * @param id Recibir un familyId de la clase Family
   * @return Todos los objetos de la clase FamilyMember por familyId
   */
  @Override
  public List<FamilyExcerpt> getFamilyMembers(int familyId) {
    log.info("Getting all familyMembers by familyId");
    return familyMemberRepository.getFamilyMembers(familyId);
  }

  /**
   * Método para crear un objeto de la clase Family
   * 
   * @param family Recibir un objeto Family para luego guardar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public Family post(Family family) {
    if (familyRepository.findById(family.getId()) == null) {
      log.info("A new family was created - {}", family.getId());
      return familyRepository.save(family);
    } else {
      log.debug("Can't create family");
      return family;
    }
  }

  /**
   * Método para actualizar un objeto de la clase Family
   * 
   * @param family Recibir un objeto Family para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public void putById(int familyId, Family family) {
    if (familyRepository.findById(family.getId()) != null) {
      log.info("Family was updated");
      family.setId(familyId);
      familyRepository.save(family);
    } else {
      log.debug("Can't update family");
    }

  }

  /**
   * Método para eliminar un objeto de la clase Family por id
   * 
   * @param id Id de Family
   */
  @Override
  public void delete(int familyId) {
    if (familyRepository.findById(familyId) != null) {
      log.info("A family was deleted");
      familyRepository.deleteById(familyId);
    } else {
      log.info("Can't delete Family");
    }
  }

  @Override
  public Family findOne(int familyId) {
    return familyRepository.findById(familyId);
  }
}
