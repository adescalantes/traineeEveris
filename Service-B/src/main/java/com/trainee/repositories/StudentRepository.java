package com.trainee.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Student;

/**
 * Repositorio de Student para la consulta de datos
 * 
 * @author Alexander
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

  public Student findById(int studentId);
}
