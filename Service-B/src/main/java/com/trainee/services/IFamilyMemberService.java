package com.trainee.services;

import java.util.List;

import com.trainee.models.FamilyMember;

public interface IFamilyMemberService {
	
	public List<FamilyMember> getAll();
	
	public FamilyMember getById(int familyMemberId);
	
	public FamilyMember post(FamilyMember familyMember);
	
	public void putById(int familyMemberId,FamilyMember familyMember);
	
	public void delete(int familyMemberId);
	
	public FamilyMember findOne(int familyMemberId);
}
