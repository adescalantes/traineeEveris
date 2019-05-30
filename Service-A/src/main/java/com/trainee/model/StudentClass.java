package com.trainee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.trainee.model.embeddable.PkStudentClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_classes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PkStudentClass.class)
public class StudentClass implements Serializable {

  @Id
  @Column(name = "date_from")
  private Date dateFrom;

  @Id
  @ManyToOne
  private Student student;

  @Id
  @ManyToOne
  private ClassModel classes;

  @Column(name = "delete_status")
  private byte deleteStatus = 1;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_to")
  private Date dateTo;
}
