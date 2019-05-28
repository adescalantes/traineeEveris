package com.trainee.service;

import java.util.List;
import java.util.Map;

import com.trainee.model.Teacher;

/**
 * Service para la entidad Teachers que contiene los métodos orientados a su
 * respectivo CRUD.
 * <p>
 * Su lógica se encuentra en TeacherServiceImplement.
 * 
 * @see com.trainee.service.implement.TeacherServiceImplement
 * @see com.trainee.model.Teacher
 * @author aescalan
 *
 */
public interface TeacherService {

  public List<Teacher> getAll();

  public Teacher getById(int teacherId);

  public Teacher post(Teacher teacher);

  public void putById(int teacherId, Teacher teacher);

  public void patchById(int teacherId, Map<String, Object> fields);

  public void delete(int teacherId);
}
