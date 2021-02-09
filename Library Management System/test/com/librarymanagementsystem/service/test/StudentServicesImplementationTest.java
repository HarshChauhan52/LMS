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
	
	private Library library=new Library ();
	private Student student=new Student(46, "hi" , "123" , "Delhi" );
	private StudentService studentservice= new StudentServicesImplementation(student,library);    // calling student service;
	private Book book ;// this book will be added to library by librarian
	
	
	
	/*-------------------checking searchBookByName function--------------------*/
		
	@Test
	public void testSearchBookByName_CheckingWhenBookDoesNotHaveAnyData_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking searchBookByName function in case book is null");
		book=new Book();                      // book does not have data
		assertEquals(false,studentservice.searchBookByName(book.getBookName()));
	}
	
	@Test
	public void testSearchBookByName_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking searchBookByName function in case book and library are not null");
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		assertEquals(true,studentservice.searchBookByName(book.getBookName()));
	}
	/*----------------------------------------------------------------------------------*/

	
	
	/*-------------------checking searchBookByAuthorName function--------------------*/
	
	@Test
	public void testSearchBookByAuthorName_CheckingWhenBookIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking SearchBookByAuthorName function in case book is null");
		book=new Book();                      // book does not have data
		assertEquals(false,studentservice.searchBookByName(book.getAuthorName()));
	}
		
	@Test
	public void testSearchBookByAuthorName_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking SearchBookByAuthorName function in case book and library are not null");
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		assertEquals(true,studentservice.searchBookByName(book.getBookName()));
	}
	/*----------------------------------------------------------------------------------*/

	
	/*-------------------checking loanABook function--------------------*/
	
	@Test
	public void testLoanABook_CheckingWhenStudentIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case student is null");
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		Student student1=null; 
		String bookName="M1"; 
		assertEquals(false,studentservice.loanABook(student1,bookName));
	}
	
	@Test
	public void testLoanABook_CheckingWhenBookNameIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case book is null");
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		String bookName=null;                           // book being searched having null value
		assertEquals(false,studentservice.loanABook(student,bookName));
	}
	
	@Test
	public void testLoanABook_CheckingWhenBookNameIsEmpty_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case book is empty");
		library=new Library ();                         // creating library
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		String bookName="";                             // empty book searching
		assertEquals(false,studentservice.loanABook(student,bookName));
	}
	
	@Test
	public void testLoanABook_CheckingWhenWrongBookIsSearched_ShouldReturnfalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case student is not null");
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);
		String bookName="M2";                            //searching wrong book
		assertEquals(false,studentservice.loanABook(student,bookName));
	}
	
	@Test
	public void testLoanABook_CheckingWhenBookAndLibraryBothAreNotNull_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking LoanABook function in case values are as per expectation");
		book=new Book("M1","Sam","Maths",50);           // creating book
		Student student1=new Student(46, "hi" , "123" , "Delhi" );
		StudentService studentservice1= new StudentServicesImplementation(student,library);    // calling student service;
		library.addBooks(book);
		String bookName="M1";                            // book being searched
		assertEquals(true,studentservice1.loanABook(student1,bookName));
	}
	/*-----------------------------------------------------------------------------------*/
	
	
	
	
	
	/*-------------------checking returnBook function-------------------------------------*/
	
	@Test
	public void testReturnBook_CheckingWhenBookIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking returnBook when book is null");
		String bookName=null;                            // book being searched
		assertEquals(false,studentservice.returnBook(student,bookName));
	}
	
	@Test
	public void testReturnBook_CheckingWhenStudentIsNull_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking returnBook when student is null");
		String bookName="M1";                            // book being searched
		Student studentNull=null;
		assertEquals(false,studentservice.returnBook(studentNull,bookName));
	}
	
	@Test
	public void testReturnBook_CheckingWhenBookNameIsEmpty_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking returnBook when book is Empty");
		String bookName="";                            // book being searched
		assertEquals(false,studentservice.returnBook(student,bookName));
	}
	
	@Test
	public void testReturnBook_CheckingWhenAllConditionsFullFilled_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking returnBook when all conditions full filled");
		
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);                         // adding book to library
		String bookName="M1";                           // book being searched
		studentservice.loanABook(student,bookName);     // student loaning the above added book
		assertEquals(true,studentservice.returnBook(student,bookName));
	}
	
	/*-----------------------------------------------------------------------------------*/


	/*-------------------checking listOfBooks function-----------------------------------*/

	@Test
	public void testListOfBooks_CheckingWhenNoBookAvailableInLibrary_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking listOfBooks when there is no book available in library");
		
		assertEquals(false,studentservice.listOfBooks());
	}

	@Test
	public void testListOfBooks_CheckingWhenBooksAreAvailableInLibrary_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking listOfBooks when there are books available in library");
		
		book=new Book("M1","Sam","Maths",50);           // creating book
		book=new Book("M2","Jim","Maths",70);           // creating another book
		library.addBooks(book);                         // adding both book to library
		
		assertEquals(true,studentservice.listOfBooks());
	}
	
	/*-----------------------------------------------------------------------------------*/

	/*-------------------checking listOfStudentsBooks function----------------------------*/

	@Test
	public void testListOfStudentsBooks_CheckingWhenNoBookIsAlerdyLoanedByStudent_ShouldReturnFalse() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking listOfStudentsBooks function when there is no book available in library");
		
		assertEquals(false,studentservice.listOfStudentsBooks());
	}

	@Test
	public void testListOfStudentsBooks_CheckingWhenBooksAreAlerdyLoanedByStudent_ShouldReturnTrue() 
	{
		LOGGER.info("In StudentServiceImplementation junit test checking listOfStudentsBooks function when there are books available in library");
		
		book=new Book("M1","Sam","Maths",50);           // creating book
		library.addBooks(book);                         // adding book to library
		studentservice.loanABook(student,book.getBookName());
		
		assertEquals(true,studentservice.listOfStudentsBooks());
	}
	
	/*-----------------------------------------------------------------------------------*/

	
}
