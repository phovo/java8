package ch.java8.workshop.java;

public class Address {
	
	private String location;
	
	private String country;
	
	public Address() {
		super();
	}

	public Address(String country) {
		super();
		this.country = country;
	}

	public Address(String location, String country) {
		super();
		this.location = location;
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "[" + location + " " + country +"]";
	}
}
