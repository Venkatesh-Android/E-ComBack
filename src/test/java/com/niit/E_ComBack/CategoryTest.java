package com.niit.E_ComBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.E_ComBack.dao.CategoryDAO;
import com.niit.E_ComBack.model.Category;

public class CategoryTest {
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Category category = (Category) context.getBean("category");
		CategoryDAO categoryDAO =(CategoryDAO) context.getBean("categoryDAO");
		
		category.setId("A-1");
		category.setName("APPLE");
		category.setDescription("Apple iPhone");
		
		categoryDAO.saveorUpdate(category);
		//categoryDAO.delete("CG120");
		
		if(categoryDAO.get("sdfsf") == null)
		{
			System.out.println("Category does not exist");
		}
		else
		{
			System.out.println("Category exists.... details are: ");
			System.out.println();
		}
	}
}
