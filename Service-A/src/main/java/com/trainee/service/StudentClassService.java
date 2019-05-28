package com.trainee.service;

import java.util.List;

import com.trainee.model.StudentClass;

public interface StudentClassService {

  public List<StudentClass> getAll();

//  public StudentClass getById(int studentClassId);

  public StudentClass post(StudentClass studentClass);

//  public void putById(int studentClassId, StudentClass studentClass);
//
//  public void patchById(int studentClassId, Map<String, Object> fields);
//
//  public void delete(int studentClassId);
}
