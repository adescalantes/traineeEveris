package com.trainee.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Parent;

/**
 * Repositorio de Parent para la consulta de datos
 * 
 * @author Alexander
 *
 */
@Repository
public interface ParentRepository extends CrudRepository<Parent, Integer> {

  public Parent findById(int parentId);

}
