package com.trainee.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

  @JsonIgnore
  @Column(name = "delete_status")
  private byte deleteStatus = 1;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "other_student_details")
  private String otherStudentDetails;

  @JsonIgnore
  @OneToMany(mappedBy = "student")
  private Set<StudentClass> studentClass;

}
