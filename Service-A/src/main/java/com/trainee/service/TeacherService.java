package com.trainee.service;

import java.util.List;
import java.util.Map;

import com.trainee.model.Teacher;

/**
 * Service para la entidad {@link Teacher} que contiene los métodos orientados a
 * su respectivo CRUD.
 * <p>
 * Su lógica se encuentra en TeacherServiceImplement.
 * 
 * @see com.trainee.service.implement.TeacherServiceImplement
 * @see com.trainee.model.Teacher
 * @author aescalan
 *
 */
public interface TeacherService {

  /**
   * Método para listar todos los objetos
   * 
   * @return Una lista de objetos
   */
  public List<Teacher> getAll();

  /**
   * Método para obtener un objeto pasando por parámetro un id
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id del
   *                  objeto
   * @return Un objeto
   */
  public Teacher getById(int teacherId);

  /**
   * Método para crear un objeto
   * 
   * @param teacher Recibe por parámetro los atributos de la entidad Teacher
   * @return Que el objeto a sido creado
   */
  public Teacher post(Teacher teacher);

  /**
   * Método para actualizar un objeto
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id del
   *                  objeto
   * @param teacher   Recibe los atributos del objeto para luego actualizarlos
   */
  public void putById(int teacherId, Teacher teacher);

  /**
   * Método para actualizar un solo campo de un objeto
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id del
   *                  objeto
   * @param fields    Recibe uno o más atributos del objeto para luego
   *                  actualizarlos
   */
  public void patchById(int teacherId, Map<String, Object> fields);

  /**
   * Método para eliminar un objeto
   * 
   * @param teacherId Recibe un parámetro de tipo int para obtener el id del
   *                  objeto
   */
  public void delete(int teacherId);
}
