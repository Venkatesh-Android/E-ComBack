package com.niit.E_ComBack.util;

/* removes the comma that preceeds the id in all table entries.*/
public class Util {

	public String replace(String st, String ch1, String ch2)
	{
		
	  return	st.replace(ch1, ch2);
		
	}
	
	
	public static void main(String[] args) {
		Util u = new Util();
		
		String newString =   u.replace(",PRD", ",", "");
		System.out.println(newString);
	}


	public static String removeComma(String name) {
		// TODO Auto-generated method stub
		return name.replace(",", "");
	}


}
