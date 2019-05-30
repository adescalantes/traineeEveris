package com.trainee.services;

import java.util.List;

import com.trainee.models.Parent;

public interface IParentService {

	public List<Parent> getAll();
	
	public Parent getById(int parentId);
	
	public Parent post(Parent parent);
	
	public void putById(int parentId,Parent parent);
	
	public void delete(int parentId);
	
	public Parent findOne(int parentId);
}
