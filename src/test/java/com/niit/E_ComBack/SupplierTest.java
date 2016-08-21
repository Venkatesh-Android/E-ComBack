package com.niit.E_ComBack;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.E_ComBack.dao.SupplierDAO;
import com.niit.E_ComBack.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		SupplierDAO supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setId("Sup-Apple-1");
		supplier.setName("Apple-Planet");
		supplier.setAddress("Coimbatore");
		supplierDAO.saveorUpdate(supplier);
		//supplierDAO.delete("CG120");
		
		if(supplierDAO.get("sdfsf") == null)
		{
			System.out.println("Supplier does not exist");
		}
		else
		{
			System.out.println("Supplier exists.... details are: ");
			System.out.println();
		}
	}
}
