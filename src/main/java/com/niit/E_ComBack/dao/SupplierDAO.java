package com.niit.E_ComBack.dao;

import java.util.List;

import com.niit.E_ComBack.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();
	
	public Supplier get(String ID);
	
	public void saveorUpdate(Supplier supplier);
	
	public void  delete(String ID);
	
	public Supplier getByName(String name);
	
	
}