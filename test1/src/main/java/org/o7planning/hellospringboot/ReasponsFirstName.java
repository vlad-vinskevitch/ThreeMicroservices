package org.o7planning.hellospringboot;

public class ReasponsFirstName {
	private String id;
	private String firstName;
	
	public ReasponsFirstName() {}
	public ReasponsFirstName(String id,String firstName) {
		this.setId(id);
	    this.setFirstName(firstName);
	  }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
