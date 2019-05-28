package com.trainee.service.implement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.trainee.model.Teacher;
import com.trainee.repository.TeacherRepository;
import com.trainee.service.TeacherService;

import lombok.extern.java.Log;

@Log
@Service
public class TeacherServiceImplement implements TeacherService {

  @Autowired
  TeacherRepository teacherRepository;

  @Override
  public List<Teacher> getAll() {
    log.info("Getting all Teachers");
    return teacherRepository.findAll();
  }

  @Override
  public Teacher getById(int teacherId) {
    log.info("Getting Teacher by id");
    Teacher teacher = teacherRepository.findById(teacherId);
    return teacher;
  }

  @Override
  public Teacher post(Teacher teacher) {
    if (teacherRepository.findById(teacher.getId()) == null) {
      log.info("Teacher was created");
      return teacherRepository.save(teacher);
    } else {
      log.info("Can't create a Teacher");
      return teacher;
    }
  }

  @Override
  public void putById(int teacherId, Teacher teacher) {
    if (teacherRepository.findById(teacherId) != null) {
      log.info("Teacher was updated");
      teacher.setId(teacherId);
      teacherRepository.save(teacher);
    } else {
      log.info("Can't update a Teacher");
    }

  }

  @Override
  public void delete(int teacherId) {
    if (teacherRepository.findById(teacherId) != null) {
      log.info("Teacher was deleted");
      teacherRepository.softDelete(teacherId);
    }

  }

  @Override
  public void patchById(int teacherId, Map<String, Object> fields) {
    Teacher teacher = getById(teacherId);

    fields.forEach((k, v) -> {

      Field field = ReflectionUtils.findRequiredField(Teacher.class, k);
      field.setAccessible(true);
      ReflectionUtils.setField(field, teacher, v);
    });
    log.info("Teacher was patched");
    teacherRepository.save(teacher);
  }

}
