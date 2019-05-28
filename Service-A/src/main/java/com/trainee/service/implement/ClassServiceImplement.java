package com.trainee.service.implement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.trainee.model.ClassModel;
import com.trainee.repository.ClassRepository;
import com.trainee.service.ClassService;

import lombok.extern.java.Log;

/**
 * Clase donde se realizá la lógica del servicio de ClassService
 * 
 * @see com.trainee.service.ClassService
 * @author aescalan
 *
 */
@Log
@Service
public class ClassServiceImplement implements ClassService {

  @Autowired
  ClassRepository classRepository;

  @Override
  public List<ClassModel> getAll() {
    log.info("Getting all classes");
    return (List<ClassModel>) classRepository.findAll();
  }

  @Override
  public ClassModel getById(int classId) {
    log.info("Getting class by id");
    ClassModel classes = classRepository.findById(classId);
    return classes;
  }

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

  @Override
  public void delete(int classId) {
    if (classRepository.findById(classId) != null) {
      log.info("Class was deleted");
      classRepository.softDelete(classId);
    }
  }

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

}
