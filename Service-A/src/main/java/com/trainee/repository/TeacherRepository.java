package com.trainee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.model.Teacher;

/**
 * Repositorio de la entidad {@link Teacher} para la obtención de datos y
 * realizar su respectivo CRUD
 * 
 * @see com.trainee.model.Teacher
 * @author aescalan
 *
 */
@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

  /**
   * Método para obtener un objeto de {@link Teacher} donde el deleteStatus sea
   * igual a 1
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id
   * @return objeto de la entidad Teacher
   */
  @Query("select t from Teacher t where t.deleteStatus=1 and t.id=?1")
  public Teacher findById(int teacherId);

  /**
   * Método para obtener una lista de objetos de {@link Teacher} donde el
   * deleteStatus sea igual a 1
   * 
   * @return lista de objetos de la entidad Teacher
   */
  @Override
  @Query("select t from Teacher t where t.deleteStatus=1")
  public List<Teacher> findAll();

  /**
   * Método para obtener una lista de objetos de {@link Teacher} donde el
   * deleteStatus sea igual a 0
   * 
   * @return lista de objetos de la entidad Teacher
   */
  @Query("select t from Teacher t where t.deleteStatus=0")
  public List<Teacher> findDeletes();

  /**
   * Método para la eliminación lógica de un objeto de {@link Teacher}
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id
   */
  @Query("update Teacher t set t.deleteStatus= 0 where t.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int teacherId);
}
