package com.trainee.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.model.StudentClass;
import com.trainee.repository.StudentClassRepository;
import com.trainee.service.StudentClassService;

import lombok.extern.java.Log;

@Log
@Service
public class StudentClassServiceImplement implements StudentClassService {

  @Autowired
  StudentClassRepository studentClassRepository;

  @Override
  public List<StudentClass> getAll() {
    log.info("Getting all studentClasses");
    return studentClassRepository.findAll();
  }

//  @Override
//  public StudentClass getById(int studentClassId) {
//    StudentClass studentClass = studentClassRepository.findById(studentClassId);
//    return studentClass;
//  }

  @Override
  public StudentClass post(StudentClass studentClass) {

    return studentClassRepository.save(studentClass);

  }

//  @Override
//  public void putById(int studentClassId, StudentClass studentClass) {
//    if (studentClassRepository.findById(studentClassId) != null) {
//      studentClass.setId(studentClassId);
//      studentClassRepository.save(studentClass);
//    }
//
//  }
//
//  @Override
//  public void patchById(int studentClassId, Map<String, Object> fields) {
//    Teacher teacher = getById(studentClassId);
//
//    fields.forEach((k, v) -> {
//
//      Field field = ReflectionUtils.findRequiredField(Teacher.class, k);
//      field.setAccessible(true);
//      ReflectionUtils.setField(field, teacher, v);
//    });
//
//    studentClassRepository.save(teacher);
//  }
//
//  @Override
//  public void delete(int studentClassId) {
//    studentClassRepository.softDelete(studentClassId);
//
//  }

}
