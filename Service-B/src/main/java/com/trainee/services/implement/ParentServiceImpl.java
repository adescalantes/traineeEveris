package com.trainee.services.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;
import com.trainee.services.IParentService;

/**
 * Clase donde se realizá la lógica de la clase Parent para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class ParentServiceImpl implements IParentService {

  @Autowired
  private ParentRepository parentRepository;
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);

  /**
   * Método para obtener todos los objetos de la clase Parents
   * 
   * @return Todos los Parents
   */
  @Override
  public List<Parent> getAll() {
    log.info("Getting All Parents");
    return (List<Parent>) parentRepository.findAll();
  }

  @Override
  public Parent getById(int parentId) {
    return parentRepository.findById(parentId);
  }

  /**
   * Método para crear un objeto de la clase Parent
   * 
   * @param parent Recibir un objeto Parent para luego guardar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public Parent post(Parent parent) {
    if (parentRepository.findById(parent.getId()) == null) {
      log.info("A new Parent was created");
      return parentRepository.save(parent);
    } else {
      log.debug("Can't create Parent");
      return parent;
    }
  }

  /**
   * Método para actualizar un objeto de la clase Parent
   * 
   * @param parent Recibir un objeto Parent para luego actualizar si se cumple la
   *               condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public void putById(int parentId, Parent parent) {
    if (parentRepository.findById(parent.getId()) != null) {
      log.info("Parent was updated");
      parent.setId(parentId);
      parentRepository.save(parent);
    } else {
      log.debug("Can't update Parent");

    }

  }

  /**
   * Método para eliminar un objeto de la clase Parent por id
   * 
   * @param id Id de Parent
   */
  @Override
  public void delete(int parentId) {
    if (parentRepository.findById(parentId) != null) {
      log.info("Parent was deleted");
      parentRepository.deleteById(parentId);

    } else {
      log.debug("Can't delete Parent");
    }

  }

  @Override
  public Parent findOne(int parentId) {
    return parentRepository.findById(parentId);
  }
}
