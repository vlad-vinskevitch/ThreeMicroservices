package org.o7planning.hellospringboot;

public class ReasponsLastName {
	public String id;

	  private String firstName;
	  private String middleName;
	  private String lastName;
	 
	  public ReasponsLastName() {}

	  public ReasponsLastName(String id, String firstName,String middleName, String lastName) {
		this.setId(id);
	    this.setFirstName(firstName);
	    this.setMiddleName(middleName);
	    this.setLastName(lastName);
	  }

	  public void setId(String id) {
			this.id = id;
		}
		public String getId() {
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
