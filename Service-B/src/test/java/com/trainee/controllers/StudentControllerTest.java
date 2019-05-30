package com.trainee.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trainee.models.Student;
import com.trainee.repositories.StudentRepository;
import com.trainee.services.IStudentService;

@RunWith(SpringRunner.class)
class StudentControllerTest {

  @Mock
  StudentRepository studentRepository;

  @Mock
  IStudentService studentService;

  @InjectMocks
  StudentController studentController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {

    MockitoAnnotations.initMocks(this);

    mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

  }

  @Test
  void testGetAll() {
    List<Student> student = new ArrayList<Student>();
    student.add(new Student(1, "mock", "mock", "mock", "mock", new Date(0), "mock"));
    student.add(new Student(2, "mockito", "mockito", "mockito", "mockito", new Date(0), "mockito"));
    student.add(new Student(3, "mocka", "mocka", "mocka", "mocka", new Date(0), "mocka"));

    when(studentService.getAll()).thenReturn(student);
    assertEquals(student, studentController.getAll());
  }

  @Test
  void testNullGetAll() {

    List<Student> student = new ArrayList<Student>();
    when(studentService.getAll()).thenReturn(student);
    assertEquals(student.isEmpty(), studentController.getAll().isEmpty());
  }

//  @Test
//  void testPostStudent() {
//
//    Student student = new Student(1, "mock", "mock", "mock", "mock", new Date(0), "mock");
//    when(studentService.post(student)).thenReturn(true);
//    assertEquals(student, studentController.getById(1));
//  }
//
//  @Test
//  void testPutStudent() {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  void testDeleteStudent() {
//    fail("Not yet implemented");
//  }
}
