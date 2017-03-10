package ch.java8.workshop.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Workshop {
	static List<Employee> employees = Arrays.asList(new Employee(1, "Laura", Role.PM, new Address("Pfalzgasse 1, Zurich", "Switzerland")),
													new Employee(2, "Julien", Role.DEV, new Address("Switzerland")),
													new Employee(3, "David", Role.QA, null),
													new Employee(4, "Simon", null, new Address("2 Rue Germain Pilon, Paris", "France")));
	
	static List<Salary> salaries = Arrays.asList(new Salary(Role.PM, Double.valueOf(6000)),
												 new Salary(Role.DEV, Double.valueOf(5000)),
												 new Salary(Role.QA, Double.valueOf(3000)));

	public static void main(String[] args) {
		displayEmployeePOJO(employees);
		System.out.println("\n\n");
		displayEmployeeJava8(employees);
	}
	
	private static void displayEmployeePOJO(List<Employee> employees) {
		Helper.showHeader();
		
		for (Employee employee : employees) {
			// get address
			String location = "N/A";
			String country = "N/A";
			Address address = employee.getAddress();
			if (address != null) {
				if (address.getLocation() != null) {
					location = address.getLocation();
				}
				if (address.getCountry() != null) {
					country = address.getCountry();
				};
			}
			
			// get salary
			String salaryValue = "N/A";
			Role role = employee.getRole();
			if (role != null) {
				for (Salary salary : salaries) {
					if (salary.getRole().equals(role)) {
						salaryValue = String.valueOf(salary.getValue());
						break;
					}
				}
			}
			
			// display the table content
			Helper.showContent(employee.getName(), location, country, salaryValue) ;
		}
	}
	
	private static void displayEmployeeJava8(List<Employee> employees) {
		Helper.showHeader();
		
		employees.forEach(employee -> {
				// get address
				Optional<Address> addressOpt = Optional.of(employee).map(Employee::getAddress);
				String location = addressOpt.map(Address::getLocation).orElse("N/A");
				String country = addressOpt.map(Address::getCountry).orElse("N/A");
				
				// get salary
				String salaryValue = salaries.stream()
											.filter(salary -> salary.getRole() == employee.getRole())
											.findFirst()
											.map(Salary::getValue)
											.map(String::valueOf).orElse("N/A");
				
				// display the table content
				Helper.showContent(employee.getName(), location, country, salaryValue) ;
			});
	}
}