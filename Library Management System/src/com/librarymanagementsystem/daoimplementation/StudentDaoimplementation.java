package com.librarymanagementsystem.daoimplementation;

import java.util.List;

import org.apache.log4j.Logger;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.ReturnBook;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.dao.StudentDao;
import com.librarymanagementsystem.serviceimplementation.StudentServicesImplementation;

public class StudentDaoimplementation implements StudentDao
{
	private static final Logger LOGGER= Logger.getLogger(StudentServicesImplementation.class.getName());

	public Book searchingBookByName(Library library, String bookName)
	{
		Book b1=new Book();
		
		for(Book book:library.seeBooks())
		{
			if(book.getBookName().equalsIgnoreCase(bookName))
			{
				b1.setBookName(book.getBookName());
				b1.setAuthorName(book.getAuthorName());
	            b1.setSubject(book.getSubject());
	            b1.setPageNo(book.getPageNo());
	        }
	    }
		
		return b1;
	}
	
	public Book searchingBookByAuthorName(Library library, String bookName)
	{
        Book b1=new Book();
		
		for(Book book:library.seeBooks())
		{
			if(book.getAuthorName().equalsIgnoreCase(bookName))
			{
				b1.setBookName(book.getBookName());
				b1.setAuthorName(book.getAuthorName());
	            b1.setSubject(book.getSubject());
	            b1.setPageNo(book.getPageNo());
	        }
	    }
		
		return b1;
	}
	
	// add book in students arrayList
	public int loaningABook(Library library,Student student,String bookName)
	{
		int i=0;
		for(Book book:library.seeBooks())
		{
			if(book.getBookName().equalsIgnoreCase(bookName))
			{
				student.addBooksToStudentsList(book);     // add book to student book list
				library.removeBooks(book);                // remove book from library which has been loaned to student
				ReturnBook returnBook=new ReturnBook(book,student);
				library.addLoanedBook(returnBook);        // add book to loaned book list in library
				i=1;
				
				break;
			}
			/*else
			{
				i=0;
			}*/
		}
		return i;
	}
	
	public int returningBook(Student student,String bookName,Library library)
	{
		int i=0;
		for(Book book:student.seeStudentBooksList())
		{
			if(book.getBookName().equalsIgnoreCase(bookName))
			{
				LOGGER.info("In StudentDaoimplementation class and in case book returned successfully.");
				student.removeBooksFromStudentsList(book);  //remove book from student book list
				library.addBooks(book);                     //adding book to library
				ReturnBook returnBook=new ReturnBook(book,student);
				library.removeLoanedBook(returnBook);       //removing book from loaned book list in library
				i=1;
				break;
			}
			else
			{
				LOGGER.info("In StudentDaoimplementation class and in case book not returned successfully.");
				i=0;
			}
		}
		
		return i;
	}
}
