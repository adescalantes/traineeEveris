package com.trainee.service.implement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.trainee.model.ClassModel;
import com.trainee.model.projection.StudentProjection;
import com.trainee.repository.ClassRepository;
import com.trainee.service.ClassService;

import lombok.extern.java.Log;

/**
 * Clase donde se implementa la lógica del servicio de {@link ClassService}
 * 
 * @author aescalan
 *
 */
@Log
@Service
public class ClassServiceImplement implements ClassService {

  @Autowired
  ClassRepository classRepository;

  /**
   * Método para retornar una lista de objetos
   */
  @Override
  public List<ClassModel> getAll() {
    log.info("Getting all classes");
    return (List<ClassModel>) classRepository.findAll();
  }

  /**
   * Método para retornar un objeto por id
   */
  @Override
  public ClassModel getById(int classId) {
    log.info("Getting class by id");
    ClassModel classes = classRepository.findById(classId);
    return classes;
  }

  /**
   * Método para crear un objeto
   */
  @Override
  public ClassModel post(ClassModel classes) {
    if (classRepository.findById(classes.getId()) == null) {
      log.info("Class was created");
      return classRepository.save(classes);
    } else {
      log.info("Can't create a Class");
      return classes;
    }
  }

  /**
   * Método para actualizar un objeto
   */
  @Override
  public void putById(int classId, ClassModel classes) {
    if (classRepository.findById(classes.getId()) != null) {
      log.info("Class was updated");
      classes.setId(classId);
      classRepository.save(classes);
    } else {
      log.info("Can't update a Class");
    }
  }

  /**
   * Método para eliminar un objeto
   */
  @Override
  public void delete(int classId) {
    if (classRepository.findById(classId) != null) {
      log.info("Class was deleted");
      classRepository.softDelete(classId);
    }
  }

  /**
   * Método para acctualizar 1 o más campos del objeto
   */
  @Override
  public void patchById(int classId, Map<String, Object> fields) {
    ClassModel classes = getById(classId);

    fields.forEach((k, v) -> {

      Field field = ReflectionUtils.findRequiredField(ClassModel.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, classes, v);
    });
    log.info("Class was patched");
    classRepository.save(classes);

  }

  @Override
  public List<StudentProjection> getAllStudents() {
    return classRepository.getAll();
  }

}
