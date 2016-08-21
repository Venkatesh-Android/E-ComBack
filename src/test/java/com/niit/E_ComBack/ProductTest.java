package com.niit.E_ComBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.E_ComBack.dao.ProductDAO;
import com.niit.E_ComBack.model.Product;

public class ProductTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	Product product = (Product) context.getBean("product");
	System.out.println("1");
	ProductDAO productDAO =(ProductDAO) context.getBean("productDAO");
	System.out.println("2");
	product.setId("P1"); // product id
	System.out.println("3");
	product.setName("iPhone6"); // product name 
	System.out.println("4");
	product.setDescription("Apple Mobile"); // product description
	System.out.println("5");
	product.setPrice("45000"); // product price
	System.out.println("6");
	product.setModel("A1386"); // product model
	System.out.println("7");
	product.setCategory_id("A-1"); //category name id
	System.out.println("8");
	product.setSupplier_id("Sup-Apple-1"); // supplier name id
	System.out.println("9");
	
 productDAO.saveorUpdate(product);// data is not getting into this statement check what is the error
 System.out.println("10");
	//categoryDAO.delete("CG120");
	
	if(productDAO.get("sdfsf") == null)
	{
		System.out.println("Product does not exist");
	}
	else
	{
		System.out.println("Product exists.... details are: ");
		System.out.println();
	}
}
}

