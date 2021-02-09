package com.librarymanagementsystem.serviceimplementation;

import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.service.LibrarianService;
import com.librarymanagementsystem.service.LoginService;

public class LoginServicesImplementation implements LoginService
{
	private int result=0;
	private Library library;
	private Librarian librarian;
	private Student student;
	private String userName;
	private String password;
	
	public LoginServicesImplementation()
	{
		
	}
	
	public LoginServicesImplementation(Library library,String userName,String password)
	{
		this.library=library;
		this.userName=userName;
		this.password=password;
	}
	
	// to identify weather the user is student or librarian 
	public int loggingIn()
	{
		if(userName==null || userName.isEmpty())
		{
			return 0;
		}
		else if(password==null || password.isEmpty())
		{
			return 0;
		}
		
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

	
	//to return librarian object this will be called when it is confirmed that user is a librarian
	public Librarian getLibrarian() 
	{
		for(Librarian lib:library.seeLibrarian())
        {
		  if(lib.getName().equalsIgnoreCase(userName) && lib.getPassword().equalsIgnoreCase(password))
      	  {
			  result=0;
      		  librarian=lib;
      		  break;
      	  }
        }
		return librarian;
	}
	
	//to return student object this will be called when it is confirmed that user is a student
	public Student getStudent() 
	{
		for(Student stu:library.seeStudents())
        {
        	if(stu.getName().equalsIgnoreCase(userName) && stu.getPassword().equalsIgnoreCase(password))
        	{
        		result=0;
        		student=stu;
        		break;
        	}
        }
	    return student;
	}

}
