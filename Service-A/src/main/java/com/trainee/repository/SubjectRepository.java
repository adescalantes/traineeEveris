package com.trainee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.model.Subject;

/**
 * Repositorio de la entidad Subject para la obtención de datos y realizar su
 * respectivo CRUD
 * 
 * @see com.trainee.model.Subject
 * @author aescalan
 *
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {

  /**
   * Método para obtener un objeto de {@link Subject} donde el deleteStatus sea
   * igual a 1
   * 
   * @param subjectId Recibe un parámetro de tipo int para obtener el id
   * @return objeto de la entidad Subject
   */
  @Query("select s from Subject s where s.deleteStatus=1 and s.id=?1")
  public Subject findById(int subjectId);

  /**
   * Método para obtener una lista de objetos de {@link Subject} donde el
   * deleteStatus sea igual a 1
   * 
   * @return lista de objetos de la entidad Subject
   */
  @Override
  @Query("select s from Subject s where s.deleteStatus=1")
  public List<Subject> findAll();

  /**
   * Método para obtener una lista de objetos de {@link Subject} donde el
   * deleteStatus sea igual a 0
   * 
   * @return lista de objetos de la entidad Subject
   */
  @Query("select s from Subject s where s.deleteStatus=0")
  public List<Subject> findDeletes();

  /**
   * Método para la eliminación lógica de un objeto de {@link Subject}
   * 
   * @param subjectId Recibe un parámetro de tipo int para obtener el id
   */
  @Query("update Subject s set s.deleteStatus= 0 where s.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int subjectId);
}
