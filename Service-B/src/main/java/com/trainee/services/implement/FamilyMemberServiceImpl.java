package com.trainee.services.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.FamilyMember;
import com.trainee.repositories.FamilyMemberRepository;
import com.trainee.services.IFamilyMemberService;

/**
 * Clase donde se realizá la lógica de la clase FamilyMember para su respectivo
 * CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class FamilyMemberServiceImpl implements IFamilyMemberService {

  @Autowired
  private FamilyMemberRepository familyMemberRepository;
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);

  /**
   * Método para obtener todos los objetos de la clase FamilyMembers
   * 
   * @return Todos los objetos de la clase FamilyMember
   */
  @Override
  public List<FamilyMember> getAll() {
    log.info("Getting All FamilyMembers");
    return (List<FamilyMember>) familyMemberRepository.findAll();
  }

  @Override
  public FamilyMember getById(int familyMemberId) {
    return familyMemberRepository.findById(familyMemberId);
  }

  /**
   * Método para crear un objeto de la clase FamilyMember
   * 
   * @param familyMember Recibir un objeto FamilyMember para luego guardar si se
   *                     cumple la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public FamilyMember post(FamilyMember familyMember) {
    if (familyMemberRepository.findById(familyMember.getId()) == null) {
      log.info("A new FamilyMember was created");
      return familyMemberRepository.save(familyMember);
    } else {
      log.debug("Can't create FamilyMember");
      return familyMember;
    }
  }

  /**
   * Método para actualizar un objeto de la clase FamilyMember
   * 
   * @param familyMember Recibir un objeto FamilyMember para luego actualizar si
   *                     se cumple la condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public void putById(int familyMemberId, FamilyMember familyMember) {
    if (familyMemberRepository.findById(familyMember.getId()) != null) {
      log.info("FamilyMember was updated");
      familyMember.setId(familyMemberId);
      familyMemberRepository.save(familyMember);
    } else {
      log.debug("Can't update FamilyMember");
    }

  }

  /**
   * Método para eliminar un objeto de la clase FamilyMember por id
   * 
   * @param id Id de FamilyMember
   */
  @Override
  public void delete(int familyMemberId) {
    if (familyMemberRepository.findById(familyMemberId) != null) {
      log.info("FamilyMember was deleted");
      familyMemberRepository.deleteById(familyMemberId);
    } else {
      log.info("Can't delete FamilyMember");
    }
  }

  @Override
  public FamilyMember findOne(int familyMemberId) {
    return familyMemberRepository.findById(familyMemberId);
  }
}
