package com.trainee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.model.ClassModel;
import com.trainee.model.projection.StudentProjection;

/**
 * Repositorio de la entidad ClassModel para la obtención de datos y realizar su
 * respectivo CRUD
 * 
 * @see com.trainee.model.ClassModel
 * @author aescalan
 *
 */
@Repository
public interface ClassRepository extends CrudRepository<ClassModel, Integer> {

  /**
   * Método para obtener un objeto de {@link ClassModel} donde el deleteStatus sea
   * igual a 1
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id
   * @return objeto de la entidad ClassModel
   */
  @Query("select c from ClassModel c where c.deleteStatus=1 and c.id=?1")
  public ClassModel findById(int classId);

  /**
   * Método para obtener una lista de objetos de {@link ClassModel} donde el
   * deleteStatus sea igual a 1
   * 
   * @return lista de objetos de la entidad ClassModel
   */
  @Override
  @Query("select c from ClassModel c where c.deleteStatus=1")
  public List<ClassModel> findAll();

  /**
   * Método para obtener una lista de objetos de {@link ClassModel} donde el
   * deleteStatus sea igual a 0
   * 
   * @return lista de objetos de la entidad ClassModel
   */
  @Query("select c from ClassModel c where c.deleteStatus=0")
  public List<ClassModel> findDeletes();

  /**
   * Método para la eliminación lógica de un objeto de {@link ClassModel}
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id
   */
  @Query("update ClassModel c set c.deleteStatus= 0 where c.id=?1")
  @Modifying
  @Transactional
  public void softDelete(int classId);

  @Query("select c from ClassModel c")
  public List<StudentProjection> getAll();
}
