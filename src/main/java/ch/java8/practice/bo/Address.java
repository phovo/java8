package ch.java8.practice.bo;

public class Address {
	
	private String houseNo;
	
	private String street;
	
	public Address() {
		super();
	}

	public Address(String houseNo, String street) {
		super();
		this.houseNo = houseNo;
		this.street = street;
	}

	public Address(String houseNo) {
		super();
		this.houseNo = houseNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String toString() {
		return "[" + houseNo + " " + street +"]";
	}
}
