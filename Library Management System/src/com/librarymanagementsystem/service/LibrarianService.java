package com.librarymanagementsystem.service;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;

public interface LibrarianService 
{
	public boolean addBooks(Library library,Book book);
	public boolean listOfBooks(Library library);
	public boolean loanedBooks(Library library);
	public boolean studentsList(Library library);
}
