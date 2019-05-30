package com.trainee.services.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;
import com.trainee.services.IStudentService;

/**
 * Clase donde se realizá la lógica de la clase Student para su respectivo CRUD
 * 
 * @author aescalan
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements IStudentService {
  private static final Logger log = LoggerFactory.getLogger(FamilyServiceImpl.class);
  @Autowired
  private StudentRepository studentRepository;

  /**
   * Método para obtener todos los objetos de la clase Students
   * 
   * @return Todos los objetos de la clase Students
   */
  @Override
  public List<Student> getAll() {
    log.info("Getting All Students");
    return (List<Student>) studentRepository.findAll();
  }

  @Override
  public Student getById(int studentId) {
	  return studentRepository.findById(studentId);
  }
  
  /**
   * Método para crear un objeto de la clase Student
   * 
   * @param student Recibir un objeto Student para luego guardar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public Student post(Student student) {
	  if (studentRepository.findById(student.getId()) == null) {
      log.info("A new Student was created");
      return studentRepository.save(student);
	  } else {
		  log.debug("Can't create a new Student");
		  return student;
	  }

  }
  

  /**
   * Método para actualizar un objeto de la clase Student
   * 
   * @param student Recibir un objeto Student para luego actualizar si se cumple la
   *                condición
   * @return Manejo de HttpStatus según sea el caso
   */
  @Override
  public void putById(int studentId,Student student) {
    if (studentRepository.findById(student.getId()) != null) {
      log.info("A new Student was updated");
      student.setId(studentId);
      studentRepository.save(student);
    } else {
      log.debug("Can't update a new Student");
    }

  }

  /**
   * Método para eliminar un objeto de la clase Student por id
   * 
   * @param id Id de Student
   */
  @Override
  public void delete(int studentId) { 
    if (studentRepository.findById(studentId) != null) {
    	log.info("Student was deleted");
    	studentRepository.deleteById(studentId);
    } else {
    	log.info("Can't delete Student");
    }

  }
  
  @Override
  public Student findOne(int studentId) {
	  return studentRepository.findById(studentId);
  }
}
