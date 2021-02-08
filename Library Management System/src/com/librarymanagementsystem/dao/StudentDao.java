package com.librarymanagementsystem.dao;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;

public interface StudentDao 
{
	public Book searchingBookByName(Library library, String bookName);
	public Book searchingBookByAuthorName(Library library, String bookName);
	public int loaningABook(Library library,Student student,String bookName);
	public int returningBook(Student student,String bookName,Library library);
}
