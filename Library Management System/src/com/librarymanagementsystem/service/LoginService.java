package com.librarymanagementsystem.service;

import com.librarymanagementsystem.beans.Librarian;
import com.librarymanagementsystem.beans.Library;
import com.librarymanagementsystem.beans.Student;

public interface LoginService 
{
	public int loggingIn();
	public Librarian getLibrarian();
	public Student getStudent();
}
