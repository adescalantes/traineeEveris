package com.trainee.model.projection;

import java.sql.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trainee.model.ClassModel;

@Projection(name = "StudentProjection", types = ClassModel.class)
@JsonPropertyOrder({ "id", "name", "code", "dateFrom", "dateTo" })
public interface StudentProjection {

  public int getId();

  public String getName();

  public String getCode();

  public Date getDateFrom();

  public Date getDateTo();

  public List<StudentClassProjection> getStudentClass();

//  public Set<StudentClass> getStudentClass();

}
