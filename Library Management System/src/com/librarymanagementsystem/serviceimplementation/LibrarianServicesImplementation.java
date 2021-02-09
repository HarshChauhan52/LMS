package com.librarymanagementsystem.serviceimplementation;

import org.apache.log4j.Logger;
import com.librarymanagementsystem.service.LibrarianService;
import com.librarymanagement.main.LibraryManagementSystem;
import com.librarymanagementsystem.beans.Address;
import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.beans.ReturnBook;
import com.librarymanagementsystem.dao.LiberarianDao;
import com.librarymanagementsystem.daoimplementation.LiberarianDaoImplementation;


public class LibrarianServicesImplementation implements LibrarianService
{
	private static final Logger LOGGER= Logger.getLogger(LibrarianServicesImplementation.class.getName());
	private Librarian librarian;
    private Library library; 
 	public LibrarianServicesImplementation() 
	{
	}
    
	public LibrarianServicesImplementation(Librarian librarian,Library library) 
	{
		this.librarian=librarian;
		this.library=library;
	}


	public Librarian getLibrarian() 
	{
		return librarian;
	}

 	
 	// function to add books
 	@Override
	public boolean addBooks(Book book)
	{
 		if(library == null)
 		{
 			return false;
 		}
 		else if (book == null)
 		{
 			return false;
 		}
 		else
 		{
 			library.addBooks(book);
 			return true;
 		}
    }
    
	// function to see list of books
 	@Override
 	public boolean listOfBooks()
	{    
 		LiberarianDao liberariandao=new LiberarianDaoImplementation();
		
 		int i=1,check=0;
		
 		LOGGER.info("In LibrarianServicesImplementation class and printing list of books.");
		
 		for(Book book : liberariandao.seeBookList(library))
		{
			System.out.println(i+" Book name : "+book.getBookName()+" , Author name : "+book.getAuthorName()+" , Subject : "+book.getSubject()+" Page no : "+book.getPageNo());
		    i++;
		    check=1;
		}
		
 		if(check==1)
		{
			System.out.println("Above are the books available");
			return true;
		}
		else
		{
			System.out.println("No Book is available yet");
			return false;
		}
	}
	
	// function to see list of loaned books
 	@Override
	public boolean loanedBooks()
	{
 		LiberarianDao liberariandao=new LiberarianDaoImplementation();
		int i=1,check=0;
		LOGGER.info("In LibrarianServicesImplementation class and printing list of books loaned.");
		for(ReturnBook returnBook:liberariandao.seeLoanedBookList(library))
		{
			Book book=returnBook.getBook();
			Student student=returnBook.getStudent();
			System.out.println(i+" Book name :"+book.getBookName()+" , Author name :"+book.getAuthorName()+" , Subject :"+book.getSubject()+" , Issued to : "+student.getName());
		    i++;
		    check=1;
		}
		if(check==1)
		{
			System.out.println("Above are the books loaned");
			return true;
		}
		else
		{
			System.out.println("No Book is loaned yet");
			return false;
		}
		
	}
 	
	// seeing students added to our library
 	@Override
 	public boolean studentsList()
 	{
 		if(library==null)
		{
		    return false;
		}
 		
 		  int i=1,check=0;
 		  LOGGER.info("In LibrarianServicesImplementation class and printing list of students registered with the library.");
		  for(Student s: library.seeStudents())
		  {
		     Address adrs=s.getAddress();
		     System.out.println(i+" ID : "+ s.getId() + " , Name : " + s.getName() + " , Permanent address : " + adrs.getAddress());
		     i++;
		     check=1;
		  }
		  if(check==1)
		  {
			  System.out.println("Above is the list of students");
			   return true;
		  }
		  else
		  {
			  System.out.println("No student is enrolled yet");
			   return false;
		  }
 	}
}
