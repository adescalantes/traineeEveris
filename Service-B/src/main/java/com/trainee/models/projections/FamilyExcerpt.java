package com.trainee.models.projections;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.trainee.models.FamilyMember;
import com.trainee.models.Parent;
import com.trainee.models.Student;

@Projection(name = "excerpt", types = FamilyMember.class)
public interface FamilyExcerpt {

  public int getId();

  public String getParentOrStudent();

  public Set<Parent> getParent();

  public Set<Student> getStudent();
}
