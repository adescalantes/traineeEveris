package com.trainee.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Entity de Student
 * <p>
 * Se mapea la base de datos
 * 
 * @author aescalan
 * @version 1.0
 */
@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "student_id")
  private int id;

  @Column(name = "gender")
  private String gender;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "other_student_details")
  private String otherStudentDetails;

  @JsonIgnore
  @ManyToMany(mappedBy = "student")
  private Set<Parent> parent;

  public Student(int id, String gender, String firstName, String middleName, String lastName, Date dateOfBirth, String otherStudentDetails) {
    this.id = id;
    this.gender = gender;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.otherStudentDetails = otherStudentDetails;
  }

}
