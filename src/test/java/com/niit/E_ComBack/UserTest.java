//package com.niit.E_ComBack;
//
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.E_ComBack.dao.UserDAO;
//
//import com.niit.E_ComBack.model.UserDetails;
//
//public class UserTest {
//	
//	public static void main(String args[])
//	{
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.niit");
//		context.refresh();
//		
//		UserDetails userDetails= (UserDetails) context.getBean("userDetails");
//		System.out.println("user 1");
//		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
//		System.out.println("user 2");
//		
//		userDetails.setEmail("abc@xyz.in");
//		System.out.println("user 3");
//		userDetails.setName("venkatesh");
//		System.out.println("user 4");
//		userDetails.setAddress("Ganapathy");
//		System.out.println("user 5");
//		userDetails.setPhone_no("1234567890");
//		System.out.println("user 6");
//		userDetails.setPassword("niit");
//		System.out.println("user 7");
//		userDetails.setAdmin(true);
//		System.out.println("user 8");
//		userDAO.saveorUpdate(userDetails);
//		System.out.println("user 9");
//		
//	}
//
//}
