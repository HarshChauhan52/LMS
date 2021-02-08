package com.librarymanagementsystem.beans;

public class ReturnBook   //it has book which is returned and the student who is returning it
{
	private Book book;
	private Student student;
	
	public ReturnBook()
	{
		
	}
	
	public ReturnBook(Book book, Student student) 
	{
		this.book = book;
		this.student = student;
	}

	public Book getBook() 
	{
		return book;
	}

	public void setBook(Book book) 
	{
		this.book = book;
	}

	public Student getStudent() 
	{
		return student;
	}

	public void setStudent(Student student) 
	{
		this.student = student;
	}
}
