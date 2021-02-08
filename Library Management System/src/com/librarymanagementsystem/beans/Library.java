package com.librarymanagementsystem.beans;

import com.librarymanagementsystem.beans.Book;
import java.util.ArrayList;
import java.util.List;

public class Library 
{
	// has a relation is being established here
	private List<Book> bookAdd = new ArrayList<Book>();                 // Library has "Books".
	private List<ReturnBook> booksLoaned = new ArrayList<ReturnBook>();             // Library has "Books".
	private List<Student> studentList = new ArrayList<Student>();       // Library has "Students".
	
	private Librarian librarian;                                        // Library has "librarian"
	private List<Librarian> librarianList = new ArrayList<Librarian>();
	
	public Library ()
	{
	}
	
	public Library (Librarian librarian)
	{
		this.librarian=librarian;
	}
	
	public void addLibrarian(Librarian librarian)   // adding librarian
	{
		librarianList.add(librarian);
	}
	
	public List<Librarian> seeLibrarian()
	{
		return(librarianList);
	}
	
	public Librarian getLibrarian()
	{
		return librarian;
	}
	
	public void addBooks(Book book) // adding books
	{
		bookAdd.add(book);
	}
	
	public void removeBooks(Book book) // removing books
	{
		bookAdd.remove(book);
	}
	
	
	public List<Book> seeBooks()
	{
		return(bookAdd);
	}
	
	public void addStudents(Student student) // adding students
	{
		studentList.add(student);
	}
	
	public List<Student> seeStudents()
	{
		return(studentList);
	}
	
	public void addLoanedBook(ReturnBook returnBook)
	{
		booksLoaned.add(returnBook);
	}
	
	public void removeLoanedBook(ReturnBook returnBook)
	{
		booksLoaned.remove(returnBook);
	}
	
	public List<ReturnBook> seeLoanedBook()
	{
		return(booksLoaned);
	}
}
