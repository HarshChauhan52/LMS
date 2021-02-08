package com.librarymanagementsystem.beans;

//is a relation happening here , extends Person is achieving this
public class Librarian extends Person
{
    private Address address;  // has a relation happening here
	
	public Librarian(int id, String name , String password , String address) 
	{
		super(name,id,password);
		this.address=new Address(address);		
	}

	public Address getAddress() 
	{
		return address;
	}

	public void setAddress(Address address) 
	{
		this.address = address;
	}
	
	
}
