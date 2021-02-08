package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.ReturnBook;

public interface LiberarianDao 
{
	public List<Book> seeBookList(Library library);
	public List<ReturnBook> seeLoanedBookList(Library library);
}
