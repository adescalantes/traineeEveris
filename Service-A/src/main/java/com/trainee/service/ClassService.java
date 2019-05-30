package com.trainee.service;

import java.util.List;
import java.util.Map;

import com.trainee.model.ClassModel;
import com.trainee.model.projection.StudentProjection;

/**
 * Service para la entidad {@link ClassModel} que contiene los métodos
 * orientados a su respectivo CRUD.
 * <p>
 * Su lógica se encuentra en ClassServiceImplement.
 * 
 * @see com.trainee.service.implement.ClassServiceImplement
 * @see com.trainee.model.ClassModel
 * @author aescalan
 *
 */
public interface ClassService {

  public List<StudentProjection> getAllStudents();

  /**
   * Método para listar todos los objetos
   * 
   * @return Una lista de objetos
   */
  public List<ClassModel> getAll();

  /**
   * Método para obtener un objeto pasando por parámetro un id
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id del objeto
   * @return Un objeto
   */
  public ClassModel getById(int classId);

  /**
   * Método para crear un objeto
   * 
   * @param classes Recibe por parámetro los atributos de la entidad ClassModel
   * @return Que el objeto a sido creado
   */
  public ClassModel post(ClassModel classes);

  /**
   * Método para actualizar un objeto
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id del objeto
   * @param classes Recibe los atributos del objeto para luego actualizarlos
   */
  public void putById(int classId, ClassModel classes);

  /**
   * Método para actualizar un solo campo de un objeto
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id del objeto
   * @param fields  Recibe uno o más atributos del objeto para luego actualizarlos
   */
  public void patchById(int classId, Map<String, Object> fields);

  /**
   * Método para eliminar un objeto
   * 
   * @param classId Recibe un parámetro de tipo int para obtener el id del objeto
   */
  public void delete(int classId);
}
