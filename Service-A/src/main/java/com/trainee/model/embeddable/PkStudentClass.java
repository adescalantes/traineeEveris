package com.trainee.model.embeddable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trainee.model.ClassModel;
import com.trainee.model.Student;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PkStudentClass implements Serializable {

  @ManyToOne
  @JoinColumn(name = "student_id", nullable = true)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "classes_id", nullable = true)
  private ClassModel classes;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_from")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
  private Date dateFrom;
}
