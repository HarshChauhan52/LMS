package com.librarymanagementsystem.serviceimplementation;

import org.apache.log4j.Logger;
import java.util.Scanner;

import com.librarymanagementsystem.service.StudentService;
import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.dao.StudentDao;
import com.librarymanagementsystem.daoimplementation.StudentDaoimplementation;

public class StudentServicesImplementation implements StudentService
{
	private static final Logger LOGGER= Logger.getLogger(StudentServicesImplementation.class.getName());
	private Student student;
	private String nameOfBook;
	private Library library;

	public StudentServicesImplementation()
	{
	}
	
	public StudentServicesImplementation(Student student,Library library)
	{
		this.student=student;
		this.library=library;
	}
	
	public Student getStudent() 
	{
		return student;
	}

	Scanner sc=new Scanner(System.in);
	
	@Override
	public boolean searchBookByName(String bookName) 
	{
		if(library==null)
		{
            return false;			
		}
		else if(bookName==null)
		{
			return false;
		}
		
		StudentDao studentdao=new StudentDaoimplementation();
		Book book=studentdao.searchingBookByName(library,bookName);
		
		int flag=0;
		
	    if(book.getBookName().equalsIgnoreCase(bookName))
	    {
	    	LOGGER.info("In StudentServicesImplementation class and in function searchBookByName.");
			flag=1;
			System.out.println("Book found");
			System.out.println(" Book name : "+book.getBookName()+" Author name : "+book.getAuthorName()+" Subject : "+book.getSubject()+" Page no : "+book.getPageNo());
		}
		
		if(flag==0)
		{
			System.out.println("Oops no such book found");
			return false;
		}
		
		else
		{
			return true;
		}
	}

	@Override
	public boolean searchBookByAuthorName(String authorName) 
	{
		if(library==null)
		{
            return false;			
		}
		else if(authorName==null)
		{
			return false;
		}
		
		StudentDao studentdao=new StudentDaoimplementation();
		Book book=studentdao.searchingBookByAuthorName(library,authorName);
		
		int flag=0;
		
		if(book.getAuthorName().equalsIgnoreCase(authorName))
		{
			LOGGER.info("In StudentServicesImplementation class and in function searchBookByAuthorName");
			flag=1;
			System.out.println("Book found");
			System.out.println(" Book name : "+book.getBookName()+" Author name : "+book.getAuthorName()+" Subject : "+book.getSubject()+" Page no : "+book.getPageNo());
		}
		if(flag==0)
		{
			System.out.println("Oops no such book found");
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean loanABook(Student student,String bookName)
	{
		if(student==null)
		{
			return false;
		}
		else if(bookName==null || bookName.isEmpty())
		{
			return false;
		}
		
		
		StudentDao studentdao=new StudentDaoimplementation();
		
        LOGGER.info("In StudentServicesImplementation class and in function loanABook.");
		
		int flag=studentdao.loaningABook(library,student,bookName);
		
		if(flag==1)
		{
			nameOfBook=bookName;
			LOGGER.info("In StudentServicesImplementation class and in function loanABook and book loaned successfully.");
			System.out.println("book loaned successfully");
			System.out.println("List of books you have :");
			for(Book books:student.seeStudentBooksList())
			{   
				System.out.println(" Book name : "+books.getBookName()+" Author name : "+books.getAuthorName()+" Subject : "+books.getSubject()+" Page no : "+books.getPageNo());
			}
			return true;
		}
	
		else
		{
			LOGGER.info("In StudentServicesImplementation class and in function loanABook and book not loaned successfully.");
			System.out.println("Book not loaned successfully");
			return false;
		}
	}
	
	@Override
	public boolean returnBook(Student student,String bookName) 
	{
		if (student==null)
		{
			return false;
		}
		else if (bookName==null)
		{
			return false;
		}
		else if (bookName=="")
		{
			return false;
		}
		
		StudentDao studentdao=new StudentDaoimplementation();
		
		LOGGER.info("In StudentServicesImplementation class and in function returnBook.");
		 
		int flag=studentdao.returningBook(student,bookName,library);
		 
		if(flag==1)
		{ 
			LOGGER.info("In StudentServicesImplementation class and in function returnBook and book returned successfully.");
			System.out.println("book returned successfully");
			return true;
		}
		else
        {
			LOGGER.info("In StudentServicesImplementation class and in function returnBook and book not returned successfully.");
			System.out.println("Book not returned successfully");
			return false;
		}
	}
	
	@Override
	public boolean listOfBooks () 
	{
		int check=0;
		LOGGER.info("In StudentServicesImplementation class and in function listOfBooks.");
		
		for(Book book:library.seeBooks())
		{
			check=1;
			System.out.println(" Book name : "+book.getBookName()+" , Author name : "+book.getAuthorName()+" , Subject : "+book.getSubject()+" , Page no : "+book.getPageNo());
		}
		
		if(check==1)
		{
			System.out.println("Above is list of books available");
			return true;
		}
		else
		{
			System.out.println("No Book is available yet");
			return false;
		}
	}
	
	
	@Override
	public boolean listOfStudentsBooks () 
	{
		int check=0;
		LOGGER.info("In StudentServicesImplementation class and in function listOfStudentsBooks.");
				
		for(Book book:student.seeStudentBooksList())
		{
			check=1;
			System.out.println(" Book name : "+book.getBookName()+" , Author name : "+book.getAuthorName()+" , Subject : "+book.getSubject()+" , Page no : "+book.getPageNo());
		}
		
		
		if(check==1)
		{
			System.out.println("Books you have");
			return true;
		}
		else
		{
			System.out.println("You don't have any book yet");
			return false;
		}
	}
	
}
