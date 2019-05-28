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
 * Modelo relacional de la entidad Subjects con sus respectivos atributos
 * 
 * @author aescalan
 *
 */
@Entity
@Table(name = "Subjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subject_id")
  private int id;

  @Column(name = "subject_name", length = 20)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "subject")
  private List<ClassModel> classes;

  @JsonIgnore
  @Column(name = "delete_status")
  private byte deleteStatus = 1;
}
