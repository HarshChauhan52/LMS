package com.librarymanagementsystem.service.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.librarymanagement.main.LibraryManagementSystem;
import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.service.LoginService;
import com.librarymanagementsystem.serviceimplementation.LoginServicesImplementation;

public class LoginServicesImplementationTest 
{
	private static final Logger LOGGER= Logger.getLogger(LoginServicesImplementationTest.class.getName());
	private Library library=new Library();
	private LoginService loginservice;
    private String userName,password;
    private Librarian librarian=new Librarian(45, "hello" , "123" , "bhopal" );
    private Student student=new Student(46, "hi" , "123" , "Delhi" );
	
	
	
	/*----------------------checking studentsList function--------------------------------*/
	@Test
	public void testloggingIn_CheckingWhenUsernameIsNull_ShouldReturn0() 
	{
		userName=null;
		password="123";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenUsernameIsEmpty_ShouldReturn0() 
	{
		userName="";
		password="123";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordIsNull_ShouldReturn0() 
	{
		userName="hello";
		password=null;
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordIsEmpty_ShouldReturn0() 
	{
		userName="hello";
		password="";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordAndUserNameAreEmpty_ShouldReturn0() 
	{
		userName="";
		password="";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordAndUserNameBothAreNull_ShouldReturn0() 
	{
		userName=null;
		password=null;
		Librarian librarian=new Librarian(45, "hello" , "123" , "bhopal" );
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordIsIncorrectAndUserNameIsCorrectForLibrarian_ShouldReturn0() 
	{
		userName="hello";
		password="1234";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenUserNameIsIncorrectAndPasswordIsCorrectForLibrarian_ShouldReturn0() 
	{
		userName="helo";
		password="123";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(0,loginservice.loggingIn());
	}
	
	@Test
	public void testloggingIn_CheckingWhenPasswordAndUserNameBothAreCorrectForLibrarian_ShouldReturn1() 
	{
		userName="hello";
		password="123";
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(1,loginservice.loggingIn());
	}
	
	
	@Test
	public void testloggingIn_CheckingWhenPasswordAndUserNameBothAreCorrectForStudent_ShouldReturn2() 
	{
		userName="hi";
		password="123";
		library.addStudents(student);                  // adding student in library
		LOGGER.info("Student created and added to library using LibraryDaoImplementationTest in LoginServicesImplementationTest");
		loginservice=new LoginServicesImplementation(library,userName,password);
		
		assertEquals(2,loginservice.loggingIn());
	}
	/*-------------------------------------------------------------------------------------*/
	
	
	/*-----------------------checking GetLibrarian function--------------------------------*/
	
	@Test
	public void testGetLibrarian() 
	{
		library.addLibrarian(librarian);               // adding librarian in library
		loginservice=new LoginServicesImplementation(library,librarian.getName(),librarian.getPassword());
		Librarian librarian1=librarian;
		LOGGER.info("testing getLibrarian function of LoginService interface");
		assertEquals(librarian1,loginservice.getLibrarian());
	}
	
	/*-------------------------------------------------------------------------------------*/
	
   /*-----------------------------checking getStudent function-----------------------------*/
	
	@Test
	public void testGetStudent() 
	{
		library.addStudents(student);               // adding librarian in library
		loginservice=new LoginServicesImplementation(library,student.getName(),student.getPassword());
		Student student1=student;
		LOGGER.info("testing getStudent function of LoginService interface");
		assertEquals(student1,loginservice.getStudent());
	}
	
	/*-------------------------------------------------------------------------------------*/
}
