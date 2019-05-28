package com.trainee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.model.StudentClass;

@Repository
public interface StudentClassRepository extends CrudRepository<StudentClass, Date> {

  @Override
  @Query("select s from StudentClass s where s.deleteStatus=1")
  public List<StudentClass> findAll();

  @Query("select s from StudentClass s where s.deleteStatus=0")
  public List<StudentClass> findDeletes(byte deleteStatus);

}
