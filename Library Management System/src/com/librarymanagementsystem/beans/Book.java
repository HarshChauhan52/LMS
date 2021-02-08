package com.librarymanagementsystem.beans;

public class Book 
{
	private String bookName,authorName,subject;
	private int pageNo;

	public Book()
	{
		
	}
	
	public Book(String bookName,String authorName,String subject,int pageNo)
	{
		this.bookName = bookName;
		this.authorName = authorName;
		this.subject = subject;
		this.pageNo = pageNo;
	}

	public String getBookName() 
	{
		return bookName;
	}

	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}

	public String getAuthorName() 
	{
		return authorName;
	}

	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}

	public String getSubject() 
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public int getPageNo() 
	{
		return pageNo;
	}

	public void setPageNo(int pageNo) 
	{
		this.pageNo = pageNo;
	}

	@Override
	public String toString() 
	{
		return "Book [bookName=" + bookName + ", authorName=" + authorName + ", subject=" + subject + ", pageNo="
				+ pageNo + "]";
	}
}
