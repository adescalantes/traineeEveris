package com.trainee.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Modelo relacional de la entidad Classes con sus respectivos atributos
 * 
 * @author aescalan
 *
 */
@Entity
@Table(name = "Classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "class_id")
  private int id;

  @Column(name = "class_code", length = 5)
  private String code;

  @Column(name = "class_name", length = 20)
  private String name;

  @Column(name = "date_from")
  private Date dateFrom;

  @Column(name = "date_to")
  private Date dateTo;

  @ManyToOne
  @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
  private Subject subject;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
  private Teacher teacher;

  @JsonIgnore
  @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
  private Set<StudentClass> studentClass;

  @JsonIgnore
  @Column(name = "delete_status")
  private byte deleteStatus = 1;
}
