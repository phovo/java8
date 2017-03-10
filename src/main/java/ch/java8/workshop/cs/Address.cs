using System;
public class Address {
	
	public string location { get; set; }
	
	public string country { get; set; }
	
	public Address(string country) {
		this.country = country;
	}

	public Address(string location, string country) {
		this.location = location;
		this.country = country;
	}
	
	public override string ToString(){
        return String.Format("{0}   |   {1}", location, country);
    }
}