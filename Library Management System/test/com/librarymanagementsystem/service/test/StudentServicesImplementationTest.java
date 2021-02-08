package com.librarymanagementsystem.service.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.service.LibrarianService;
import com.librarymanagementsystem.service.StudentService;
import com.librarymanagementsystem.serviceimplementation.LibrarianServicesImplementation;
import com.librarymanagementsystem.serviceimplementation.StudentServicesImplementation;

public class StudentServicesImplementationTest 
{
private static final Logger LOGGER= Logger.getLogger(LibrarianServicesImplementation.class.getName());
	
	private Library library;
	private Student student=new Student(46, "hi" , "123" , "Delhi" );
	private StudentService studentservice= new StudentServicesImplementation(student);    // calling student service;
	private Book book ;// this book will be added to library by librarian
	
	
	
	/*-------------------checking searchBookByName function--------------------*/
		
	/*@Test
	public void testSearchBookByName_CheckingWhenBookDoesNotHaveAnyData_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking searchBookByName function in case book is null");
		library=new Library ();               // creating library
		book=new Book();                      // book does not have data
		assertEquals(false,studentservice.searchBookByName(library,book.getBookName()));
	}
	
	@Test
	public void testSearchBookByName_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking searchBookByName function in case book and library are not null");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		assertEquals(true,studentservice.searchBookByName(library,book.getBookName()));
	}*/
	/*-----------------------------------------------------------------------------------*/

	
	
	/*-------------------checking searchBookByAuthorName function--------------------*/
	
	/*@Test
	public void testSearchBookByAuthorName_CheckingWhenBookIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking SearchBookByAuthorName function in case book is null");
		library=new Library ();               // creating library
		book=new Book();                      // book does not have data
		assertEquals(false,studentservice.searchBookByName(library,book.getAuthorName()));
	}
		
	@Test
	public void testSearchBookByAuthorName_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking SearchBookByAuthorName function in case book and library are not null");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		assertEquals(true,studentservice.searchBookByName(library,book.getBookName()));
	}*/
	/*-----------------------------------------------------------------------------------*/

	
	/*-------------------checking loanABook function--------------------*/
	
	@Ignore
	public void testLoanABook_CheckingWhenStudentIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case student is null");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		Student student1=null; 
		assertEquals(false,studentservice.loanABook(library,student1));
	}
	
	
	
	@Test
	public void testLoanABook_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case student is not null");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		System.out.println(studentservice.loanABook(library,student));
	}
	/*-----------------------------------------------------------------------------------*/
	
	
}
