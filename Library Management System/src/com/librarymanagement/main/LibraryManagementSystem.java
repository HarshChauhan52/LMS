package com.librarymanagement.main;

import org.apache.log4j.Logger;
import java.util.Scanner;
import com.librarymanagementsystem.beans.*;
import com.librarymanagementsystem.dao.LibraryDao;
import com.librarymanagementsystem.daoimplementation.LibraryDaoImplementation;
import com.librarymanagementsystem.service.*;
import com.librarymanagementsystem.serviceimplementation.*;
import com.librarymanagementsystem.serviceimplementation.LibrarianServicesImplementation;
import com.librarymanagementsystem.serviceimplementation.StudentServicesImplementation;


/*main class*/
public class LibraryManagementSystem 
{
	private static final Logger LOGGER= Logger.getLogger(LibraryManagementSystem.class.getName());
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		LibraryDao libraryDao= new LibraryDaoImplementation();
		
		// creating library
	    Library library=libraryDao.getLibrary();
	    LOGGER.info("Library created");
		
	    // getting the librarian 
	 	Librarian librarian1=libraryDao.creatingLibrarianAddingToLibrary();
	 	LOGGER.info("libraryDao called for librarian creation and addition to library");
	 	
	    // getting the student 
	 	Student student1=libraryDao.creatingStudentAddingToLibrary();
	 	LOGGER.info("libraryDao called for student creation and addition to library");
	 	
	    
	    LOGGER.info("Services refrence created");
	    /* services : librarian , student (login service also called here and initialized) 
	    initialized below according to librarian , student login*/
	 	LibrarianService librarianservice;
	 	StudentService studentservice;
	    
	 	
	 	
	    // main program functionality starts from here
	    int repetation=1;
	    do
	    {
	    	  System.out.println("Enter User Name :");
			  String userName=sc.next();
			  System.out.println("Enter password :");
			  String password=sc.next();
			 
			  LOGGER.info("Login service class called");
			  LoginService login=new LoginServicesImplementation(library,userName,password);
			  
	          int choice=login.loggingIn();
		
		       if(choice==1)	   
		       {
		    	  LOGGER.info("Login successfull for Librarian module.");
				  //    	   
		    	  librarianservice = new LibrarianServicesImplementation(login.getLibrarian(),library);
			 	
				  int repeat=1;
				  do
				  {
				  LOGGER.info("In librarian module.");
			      System.out.println("Login successfull");
			      LOGGER.info("Showing librarian module's menu.");
        		  System.out.println("what do you want to do... \n 1).Add books to library \n 2).List of books available at library \n 3).List of books loaned to students \n 4).List of students \n 5).Log out");
        		  int option=sc.nextInt();
        		  
        		  switch(option)
        		  {
        			   case 1:
        				   int repeat1=1;
        				   do
        				   {
        					   LOGGER.info("In librarian module functionality 1).Add books.");
        					   System.out.println("Book name :");
        					   String bookName=sc.next();
        					   System.out.println("Author name :");
        					   String authorName=sc.next();
        					   System.out.println("Subject :");
        					   String subject=sc.next();
        					   System.out.println("Page no :");
        					   int pageNo=sc.nextInt();
        					   
        					   // creating the above book to add in library (will be added by this librarian)
        					   Book book=new Book(bookName,authorName,subject,pageNo);
        					   
        					   // books being added to library by this librarian
        					   boolean check=librarianservice.addBooks(book);
        					   if(check==true)
        					   {
        						   System.out.println("Book added successfully");
        					   }
        					   else 
        					   {
        						   System.out.println("Book not added successfully");
        					   }
        					   
        					   System.out.println("If you want to continue adding books press 1 else 2");
        					   repeat1=sc.nextInt();
        					}
        				    while(repeat1==1);
        			   break;
        			   
        			   case 2:
        				
        				   LOGGER.info("In librarian module functionality 2).List of books.");
        				   // seeing books added by this librarian to library
        				   librarianservice.listOfBooks();
        					
            		   break;
            			   
        			   case 3:
        				
        				   LOGGER.info("In librarian module functionality 3).List of books loaned.");
        				   // seeing books loaned
        				   librarianservice.loanedBooks();
            		   
        			   break;
            		   
        			   case 4:
        				   
        				   LOGGER.info("In librarian module functionality 4).List of students");
        				   // seeing students added to our library
        				   librarianservice.studentsList();
        			   
        			   break;
        			   
                       case 5:
                    	   LOGGER.info("Logging out");
        			   break;
            		   
            		   default:
            			   LOGGER.info("In librarian module functionality inside incase when invalid choice is selected");
            			   System.out.println("Invalid choice");
            		   break;
        		  }
        		  LOGGER.info("In librarian module functionality asking user wheather to continue or not");
        		  System.out.println("If you want to continue as Librarian press 1 else if you want to logout press 2");
    			  repeat=sc.nextInt();
    			  }
    			  while(repeat==1);
    		  }
		      
			  else if(choice==2)
        	  {
				  LOGGER.info("Login successfull for Student module.");
				  //
				  studentservice = new StudentServicesImplementation(login.getStudent(),library);
				  Student student=login.getStudent(); 
				  
				  int repeating=1;
          		  do
          		  {
          			   LOGGER.info("In student module");
          			   System.out.println("Login successfull");
          			   LOGGER.info("Showing student module's menu.");
  	            	   System.out.println("what do you want to do... \n 1).Search a book by it's name/title \n 2).Search a book by it's Author \n 3).Loan a book \n 4).Return a book \n 5).See books avaiable \n 6).Log out");
  	            	   int option=sc.nextInt();
  	            	    
  	            		  switch(option)
  	            		  {
  	            			   case 1:
  	            				   
  	            				   int repeat2=1;
  	            				   do
  	            				   {
  	            					   LOGGER.info("In student module functionality 1).Search a book by it's name/title.");
  	            					   System.out.println("Book name :");
  	            					   String bookName=sc.next();
  	            					   
  	            					   // student searching for a book by book's name/title
  	            					   studentservice.searchBookByName(bookName);
  	            					   
  	            					   System.out.println("If you want to continue searching books press 1 else 2");
  	            					   repeat2=sc.nextInt();
  	            					}
  	            				    while(repeat2==1);  
  	            				   
  	            			   break;
  	            			   
  	            			   case 2:
  	            				   
  	            				   int repeat3=1;
  	            				   do
  	            				   {
  	            					   LOGGER.info("In student module functionality 2). Search a book by it's Author.");
  	            					   System.out.println("Author name :");
  	            					   String authorName=sc.next();
  	            					   
  	            					   // student searching for a book by book's author name
  	            					   studentservice.searchBookByAuthorName(authorName);
  	            					   
  	            					   System.out.println("If you want to continue searching books press 1 else 2");
  	            					   repeat3=sc.nextInt();
  	            					}
  	            				    while(repeat3==1);
  	            				   
  	                		   break;
  	                			   
  	            			   case 3:
  	            				   
  	            				   int repeat4=1;
  	            				   do
  	            				   {
  	            					   LOGGER.info("In student module functionality 3).Loan a book.");
  	            					   
  	            					   studentservice.listOfBooks ();
  	            					   
  	            					   System.out.println("Enter book name :");
  	            					   String bookName=sc.next();
  	            					   
  	            					   // loan a book
  	            					   studentservice.loanABook(student,bookName);
  	            					   System.out.println("If you want to continue loaning books press 1 else 2");
  	            					   repeat4=sc.nextInt();
  	            				   }
  	            				   while(repeat4==1);
  	            					
  	            			   break;
  	                		   
  	            			   case 4:
  	            				   
  	            				   int repeat5=1;
  	            				   do
  	            				   {
  	            					    studentservice.listOfStudentsBooks();
  	            					    System.out.println("Enter book name you want to return:");
  	            					    String bookName=sc.next();
  	            					
  	            					    LOGGER.info("In student module functionality 4).Return a book.");
  	            						// return a book
  	            						studentservice.returnBook(student,bookName);
  	            						
  	            						System.out.println("If you want to continue returning books press 1 else 2");
	    	            			    repeat5=sc.nextInt();
  	            				   }
  	            				   while(repeat5==1);
  	            					
                                 break;
                                 
  	            			     case 5:
  	            				   
  	            				   LOGGER.info("In student module functionality 5).See books avaiable.");
  	            				   studentservice.listOfBooks();
  	            				   
	    	            	     break;		
  	                		   
  	            			     case 6:
  	            			    	LOGGER.info("Logging out");
  	              			     break;
	    	            	     
  	                		     default:
  	                			   LOGGER.info("In Student module functionality inside incase when invalid choice is selected");
  	                			   System.out.println("Invalid choice");
  	                		     break;
  	            		  }
  	            LOGGER.info("In Student module functionality asking user wheather to continue or not");
  	            System.out.println("If you want to continue as Student press 1 else if you want to logout press 2");
  	            repeating=sc.nextInt();
  	        	}
          		while(repeating==1);
              }
		      else
	          {
		    	    LOGGER.info("When login of user fails");
	            	System.out.println("Login not successfull");
	          }
	    
		LOGGER.info("Asking user wheather he/she wants to continue or not");
	    System.out.println("If you want to continue with application press 1 else press 2");
		repetation=sc.nextInt();
		}
		while(repetation==1);	  
    }
}
