package com.trainee.model.projection;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.trainee.model.Student;
import com.trainee.model.StudentClass;

@Projection(name = "StudentClassProjection", types = StudentClass.class)
public interface StudentClassProjection {

  List<Student> getStudent();
}
