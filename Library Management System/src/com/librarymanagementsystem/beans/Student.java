package com.librarymanagementsystem.beans;

import com.librarymanagementsystem.beans.Book;
import java.util.ArrayList;
import java.util.List;

// is a relation happening here , extends Person is achieving this
public class Student extends Person
{
	private Address address;                                            // has a relation happening here
	private List<Book> studentBookAdd = new ArrayList<Book>();                 // Student has "Books".
    
	public Student(int id, String name , String password , String address) 
	{
		super(name,id,password);
		this.address=new Address(address);		
	}
	
	public Address getAddress()
	{
		return address;
	}
	
	public void addBooksToStudentsList(Book book)
	{
		studentBookAdd.add(book);
	}
	
	public void removeBooksFromStudentsList(Book book)
	{
		studentBookAdd.remove(book);
	}
	
	public List<Book> seeStudentBooksList()
	{
		return(studentBookAdd);
	}
}
