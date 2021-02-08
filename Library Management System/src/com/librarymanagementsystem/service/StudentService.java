package com.librarymanagementsystem.service;

import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;

public interface StudentService 
{
	public boolean searchBookByName(Library library,String bookName);
	public boolean searchBookByAuthorName(Library library,String authorName);
	public boolean loanABook(Library library,Student student);
	public void returnBook (Student student,Library library);
	public void listOfBooks (Library library);
}
