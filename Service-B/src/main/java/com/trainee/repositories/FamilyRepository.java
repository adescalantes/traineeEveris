package com.trainee.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.Family;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Integer> {

  public Family findById(int familyId);

}
