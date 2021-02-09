package com.librarymanagementsystem.service.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.apache.log4j.Logger;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.ReturnBook;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.service.LibrarianService;
import com.librarymanagementsystem.serviceimplementation.LibrarianServicesImplementation;

public class LibrarianServicesImplementationTest 
{
	private static final Logger LOGGER= Logger.getLogger(LibrarianServicesImplementation.class.getName());
	
	private Library library=new Library();
	private Librarian librarian=new Librarian(45, "hello" , "123" , "bhopal" );          // creating librarian for our library
	private LibrarianService librarianservice= new LibrarianServicesImplementation(librarian,library); // calling librarian service;
	private Book book ;// this book will be added to library by librarian
	private Student student;
	
	/*-------------------checking addBooks function--------------------*/
	
	@Test
	public void testAddBooks_CheckingWhenBookIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking addBooks function in case book is null");
		library=new Library ();               // creating library
		book=null;                            // creating null book 
		assertEquals(false,librarianservice.addBooks(book));
	}
	
	@Test
	public void testAddBooks_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking addBooks function in case book and library are not null");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book 
		assertEquals(true,librarianservice.addBooks(book));
	}
	/*-----------------------------------------------------------------------------------*/
	
	
	/*----------------------checking listOfBooks function--------------------------------*/
	
	@Test
	public void testListOfBooks_CheckingWhenBookIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking listOfBooks function in case book is null");
		library=new Library();                           // creating library
		book=null;                                       // creating null book
		librarianservice.addBooks(book);
		assertEquals(false,librarianservice.listOfBooks());
	}
	
	@Ignore
	public void testListOfBooks_CheckingWhenBookAndLibraryBothIsNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking listOfBooks function in case book and library both are not null");
		book=new Book("M1","Sam","Maths",50);            // creating book
		librarianservice.addBooks(book);
		assertEquals(true,librarianservice.listOfBooks());
	}
	
	/*-----------------------------------------------------------------------------------*/
	
	
	
	/*----------------------checking loanedBooks function--------------------------------*/
	
	@Test
	public void testLoanedBooks_CheckingWhenLibraryIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking loanedBooks function in case library is null");
		library=null;                                   // creating null library
		librarianservice.loanedBooks();
		assertEquals(false,librarianservice.loanedBooks());
	}
	
	@Test
	public void testLoanedBooks_CheckingWhenLibraryIsNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking loanedBooks function in case library is not null");
		student=new Student(46, "hi" , "123" , "Delhi");// creating student
		library.addStudents(student);
		book=new Book("M1","Sam","Maths",50);           // creating book
		ReturnBook returnBook=new ReturnBook(book,student); // creating return book
		library.addLoanedBook(returnBook);
		assertEquals(true,librarianservice.loanedBooks());
	}
	
	
	/*-----------------------------------------------------------------------------------*/


	
	
	/*----------------------checking studentsList function--------------------------------*/
	
	@Test
	public void testStudentsList_CheckingWhenLibraryIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking studentsList function in case library is null");
		library=null;                                   // creating null library
		assertEquals(false,librarianservice.studentsList());
	}
	
	@Test
	public void testStudentsList_CheckingWhenLibraryIsNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In LibrarianServicesImplementation junit test checking studentsList function in case library is not null");
		student=new Student(46, "hi" , "123" , "Delhi");// creating student
		library.addStudents(student);
		assertEquals(true,librarianservice.studentsList());
	}
	
	/*-----------------------------------------------------------------------------------*/

}
