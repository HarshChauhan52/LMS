package com.librarymanagementsystem.daoimplementation;

import java.util.List;

import com.librarymanagementsystem.beans.Book;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.ReturnBook;
import com.librarymanagementsystem.dao.LiberarianDao;

public class LiberarianDaoImplementation implements LiberarianDao
{
	public List<Book> seeBookList(Library library)
	{
		return(library.seeBooks());
	}
	
	public List<ReturnBook> seeLoanedBookList(Library library)
	{
		return(library.seeLoanedBook());
	}

}
