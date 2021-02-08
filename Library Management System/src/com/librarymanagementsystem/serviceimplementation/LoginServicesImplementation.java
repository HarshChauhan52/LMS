package com.librarymanagementsystem.serviceimplementation;

import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.service.LibrarianService;
import com.librarymanagementsystem.service.LoginService;

public class LoginServicesImplementation implements LoginService
{
	private int result=0;
	private Librarian librarian;
	private Student student;
	
	public int loggingIn(String userName,String password,Library library)
	{
		for(Librarian lib:library.seeLibrarian())
        {
		  if(lib.getName().equalsIgnoreCase(userName) && lib.getPassword().equalsIgnoreCase(password))
      	  {
      		  librarian=lib;
      		  result=1;
      		  break;
      	  }
        }
		
		for(Student stu:library.seeStudents())
        {
        	if(stu.getName().equalsIgnoreCase(userName) && stu.getPassword().equalsIgnoreCase(password))
        	{
        		student=stu;
        		result=2;
        		break;
        	}
        }
	
		return result;
	}

	public Librarian getLibrarian() 
	{
		return librarian;
	}
	
	public Student getStudent() 
	{
		return student;
	}

}
