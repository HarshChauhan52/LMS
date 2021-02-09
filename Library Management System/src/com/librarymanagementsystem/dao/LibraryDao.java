package com.librarymanagementsystem.dao;

import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;

public interface LibraryDao 
{
	public Library getLibrary();
	public Librarian creatingLibrarianAddingToLibrary();
	public Student creatingStudentAddingToLibrary();
}
