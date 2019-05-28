package com.trainee.service;

import java.util.List;
import java.util.Map;

import com.trainee.model.Subject;

/**
 * Service para la entidad {@link Subject} que contiene los métodos orientados a
 * su respectivo CRUD.
 * <p>
 * Su lógica se encuentra en SubjectServiceImplement.
 * 
 * @see com.trainee.service.implement.SubjectServiceImplement
 * @see com.trainee.model.Subject
 * @author aescalan
 *
 */
public interface SubjectService {

  /**
   * Método para listar todos los objetos
   * 
   * @return Una lista de objetos de la entidad Subject
   */
  public List<Subject> getAll();

  /**
   * Método para obtener un objeto pasando por parámetro un id
   * 
   * @param subjectId Recibe un parámetro de tipo int para obtener el id del
   *                  objeto
   * @return Un objeto de la entidad Subject
   */
  public Subject getById(int subjectId);

  /**
   * Método para crear un objeto
   * 
   * @param subject Recibe por parámetro los atributos de la entidad Subject
   * @return Que el objeto a sido creado
   */
  public Subject post(Subject subject);

  public void putById(int subjectId, Subject subject);

  public void patchById(int subjectId, Map<String, Object> fields);

  public void delete(int subjectId);
}
