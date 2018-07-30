package com.grocerybackend.DAO;

import java.util.List;

import com.grocerybackend.model.Category;



public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	
	public  List<Category>getAll() ;
	public Category getSingleCategory(int pid);
	public boolean DeleteCategory(Category category);
}
