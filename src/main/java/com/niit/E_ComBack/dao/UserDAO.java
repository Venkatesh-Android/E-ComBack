package com.niit.E_ComBack.dao;

import java.util.List;

import com.niit.E_ComBack.model.UserDetails;



public interface UserDAO {

	public List<UserDetails> list();
	public UserDetails get(String id);
	public UserDetails getUsernmae(String id);
	public void saveorUpdate(UserDetails userDetails);
	public boolean isValidUser(String id, String password);
	public boolean AdminCheck(String id,boolean isAdmin);
	public void delete(String id);
}
