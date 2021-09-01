package org.o7planning.hellospringboot;

import org.springframework.data.annotation.Id;

public class Customer {

	  @Id
	  public String id;

	  private String firstName;
	  private String middleName;
	  private String lastName;
	 
	  public Customer() {}

	  public Customer(String firstName,String middleName, String lastName) {
	    this.setFirstName(firstName);
	    this.setMiddleName(middleName);
	    this.setLastName(lastName);
	  }
	  
	  @Override
	  public String toString() {
	    return String.format(
	        "id=%s, firstName='%s',middleName='%s', lastName='%s'",
	        id, getFirstName(),getMiddleName() ,getLastName());
	  }

	  public String setId() {
			return id;
		}
	  
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	}
