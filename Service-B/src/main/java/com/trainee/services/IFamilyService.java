package com.trainee.services;

import java.util.List;

import com.trainee.models.Family;
import com.trainee.models.projections.FamilyExcerpt;

public interface IFamilyService {

  public List<Family> getAll();

  public Family getById(int familyId);

  public List<FamilyExcerpt> getFamilyMembers(int familyId);

  public Family post(Family family);

  public void putById(int familyId, Family family);

  public void delete(int familyId);

  public Family findOne(int familyId);
}
