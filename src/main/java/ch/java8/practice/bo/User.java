package ch.java8.practice.bo;

import java.util.Set;

public class User {
	
	private String name;
	
	private UserRole role;
	
	private Address address;
	
	private Set<Address> history;
	
	private Set<UserRole> roles;

	public User() {
		super();
	}
	
	public User(String name, UserRole role) {
		super();
		this.name = name;
		this.role = role;
		this.address = null;
	}
	
	public User(User user) {
		super();
		this.name = user.name;
		this.role = user.role;
		this.address = user.address;
	}
	
	public User(String name, Set<UserRole> roles) {
		super();
		this.name = name;
		this.roles = roles;
	}

	public User(String name, UserRole role, Address address) {
		super();
		this.name = name;
		this.role = role;
		this.address = address;
	}
	
	public User(String name, UserRole role, Address address, Set<Address> history) {
		super();
		this.name = name;
		this.role = role;
		this.address = address;
		this.history = history;
	}

	public boolean isAdmin() {
		return role.equals(UserRole.ADMIN);
	}
	
	public static User clone(User user) {
		return isNull(user) ? null : new User(user.name, user.role);
	}
	
	static boolean isNull(User user) {
		return user == null;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Address> getHistory() {
		return history;
	}

	public void setHistory(Set<Address> history) {
		this.history = history;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String toString() {
		return "[" + name + " " + role + " " + address + "]";
	}
}