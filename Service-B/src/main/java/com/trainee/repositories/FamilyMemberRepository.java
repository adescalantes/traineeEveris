package com.trainee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trainee.models.FamilyMember;
import com.trainee.models.projections.FamilyExcerpt;

/**
 * Repositorio de FamilyMember para la consulta de datos
 * 
 * @author Alexander
 *
 */

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Integer> {

  public List<FamilyMember> findByFamilyId(int familyMemberId);

  @Query("Select fm from FamilyMember fm where fm.family.id =?1")
  public List<FamilyExcerpt> getFamilyMembers(int familyMemberId);

  public FamilyMember findById(int familyMemberId);

}
