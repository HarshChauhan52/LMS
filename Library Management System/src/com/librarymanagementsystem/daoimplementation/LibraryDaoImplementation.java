package com.librarymanagementsystem.daoimplementation;

import org.apache.log4j.Logger;

import com.librarymanagement.main.LibraryManagementSystem;
import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;
import com.librarymanagementsystem.dao.LibraryDao;

public class LibraryDaoImplementation implements LibraryDao 
{
	private static final Logger LOGGER= Logger.getLogger(LibraryDaoImplementation.class.getName());
	private Library library; 
	
	public Library getLibrary()
	{
		//creating library
		library=new Library();
		LOGGER.info("Library created using LibraryDaoImplementation");

        return library;	
	}
	
	public Librarian creatingLibrarianAddingToLibrary()
	{
		// adding new librarian to project
		Librarian librarian=new Librarian(45, "hello" , "123" , "bhopal" );
		library.addLibrarian(librarian);               // adding librarian in library
		LOGGER.info("Librarian created and added to library using LibraryDaoImplementation");
		return librarian; 
	}
	
	
	public Student creatingStudentAddingToLibrary()
	{
		// adding new student to project
		Student student=new Student(46, "hi" , "123" , "Delhi" );
		library.addStudents(student);                  // adding student in library
		LOGGER.info("Student created and added to library using LibraryDaoImplementation");
		return student; 
	}
	
}




