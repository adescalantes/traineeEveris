package com.trainee.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Clase Entity de Parent
 * <p>
 * Se mapea la base de datos
 * 
 * @author aescalan
 * @version 1.0
 */

@Entity
@Table(name = "parents")
@Data
public class Parent {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "parent_id")
  private int id;

  @Column(name = "gender")
  private String gender;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "other_parent_details")
  private String otherParentDetails;

  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "student_parents",
      joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "parent_id"),
      inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
  private Set<Student> student;

}
