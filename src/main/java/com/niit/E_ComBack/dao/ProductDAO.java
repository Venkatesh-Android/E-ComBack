package com.niit.E_ComBack.dao;

import java.util.List;

import com.niit.E_ComBack.model.Product;

public interface ProductDAO {
	public List<Product> list();

	public Product get(String ID);

	public void saveorUpdate(Product product);

	public void delete(String ID);

}
