package org.o7planning.hellospringboot;

public class ReasponsMiddleName {
	private String id;
	private String firstName;
	private String midlleName;
	
	public ReasponsMiddleName() {}
	public ReasponsMiddleName(String id ,String firstName, String midlleName ) {
		this.setId(id);
	    this.setFirstName(firstName);
	    this.setMidlleName(midlleName);
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
	public String getMidlleName() {
		return midlleName;
	}
	public void setMidlleName(String midlleName) {
		this.midlleName = midlleName;
	}
}
