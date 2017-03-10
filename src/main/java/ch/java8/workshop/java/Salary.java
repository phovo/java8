package ch.java8.workshop.java;

public class Salary {
	
	private Role role;
	
	private Double value;
	
	public Salary() {
		super();
	}

	public Salary(Role role, Double value) {
		super();
		this.role = role;
		this.value = value;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
