package com.grocerybackend.DAO;

import java.util.List;

import com.grocerybackend.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	
	public List<User> getAll();
	public User getSingleUser(int sid);
	public boolean DeleteUser(User user);
    public User getEmail(String email);
	
	

}
