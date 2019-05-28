package com.trainee.model;

import java.util.List;

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

/**
 * Modelo relacional de la entidad Teachers con sus respectivos atributos
 * 
 * @author aescalan
 *
 */
@Entity
@Table(name = "Teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private int id;

  @Column(name = "gender", length = 10)
  private String gender;

  @Column(name = "first_name", length = 20)
  private String firstName;

  @Column(name = "middle_name", length = 20)
  private String middleName;

  @Column(name = "last_name", length = 20)
  private String lastName;

  @Column(name = "other_teacher_details", length = 40)
  private String otherTeacherDetails;

  @JsonIgnore
  @OneToMany(mappedBy = "teacher")
  private List<ClassModel> classes;

  @JsonIgnore
  @Column(name = "delete_status")
  private byte deleteStatus = 1;
}
