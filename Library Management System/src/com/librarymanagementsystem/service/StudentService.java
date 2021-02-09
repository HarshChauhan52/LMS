package com.librarymanagementsystem.service;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;

public interface StudentService 
{
	public boolean searchBookByName(String bookName);
	public boolean searchBookByAuthorName(String authorName);
	public boolean loanABook(Student student,String bookName);
	public boolean returnBook (Student student,String bookName);
	public boolean listOfBooks ();
	public boolean listOfStudentsBooks ();
}
