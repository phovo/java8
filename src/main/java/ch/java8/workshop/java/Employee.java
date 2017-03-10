package ch.java8.workshop.java;

public class Employee {
	
	private long id;
	
	private String name;
	
	private Role role;
	
	private Address address;
	
	public Employee() {
		super();
	}

	public Employee(long id, String name, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Employee(long id, String name, Role role, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
