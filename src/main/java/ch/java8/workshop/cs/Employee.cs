using System;
public class Employee {
    public long id { get; set; }
	
	public string name { get; set; }
	
	public Role role { get; set; }
	
	public Address address { get; set; }
	
	public Employee() {
	}

	public Employee(long id, string name, Role role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Employee(long id, string name, Role role, Address address) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.address = address;
	}
	
	public Employee(long id, string name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public override string ToString(){
        return String.Format("{0}   |   {1}   |   ", name, address);
    }
}