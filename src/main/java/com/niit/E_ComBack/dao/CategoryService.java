package com.niit.E_ComBack.dao;

import java.util.List;
import com.niit.E_ComBack.model.Category;

public interface CategoryService {
	
	public List<Category> list();
	
	public Category get(String ID);
	
	public void saveorUpdate(Category category);
	
	public void  delete(String ID);
	
	public Category getByName(String name);

	
}
