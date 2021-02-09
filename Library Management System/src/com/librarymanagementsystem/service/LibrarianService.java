package com.librarymanagementsystem.service;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;

public interface LibrarianService 
{
	public boolean addBooks(Book book);
	public boolean listOfBooks();
	public boolean loanedBooks();
	public boolean studentsList();
}
