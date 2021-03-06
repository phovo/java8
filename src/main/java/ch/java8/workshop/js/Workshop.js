var Role = {
	PM: "PM",
	DEV: "DEV",
	QA: "QA"
};

var Salary = {
	PM: 6000,
	DEV: 5000,
	QA: 3000
}
	
var employees = [{id: 1, name: "Laura", role: Role.PM, address: {location: "Pfalzgasse 1, Zurich", country: "Switzerland"}},
		  		 {id: 2, name: "Julien",role: Role.DEV,address: {location:null, country: "France"}},
				 {id: 3, name: "David", role: Role.QA, address: null},
				 {id: 4, name: "Simon", role: null, address: {location: "2 Rue Germain Pilon, Paris", country: "France"}}];


function padLeft (str, max) {
	var pad = " ".repeat(max);
	return (pad + str).slice(-pad.length);
}

function showHeader() {
	console.log(padLeft("Name",  10), padLeft("Address", 35), padLeft("Country", 20), padLeft("Salary", 20))
	console.log("--".repeat(50));
}

showHeader();
employees.forEach(function(employee){
	var location = "N/A";
	var country = "N/A";
  
	var address = employee.address;
	if (address != null) {
		if (address.location != null) {
			location = address.location;
		}
		if (address.country != null) {
			country = address.country;
		}
	}
	
	var salaryValue = "N/A";
	for (var role in Role) {
		if (Role.PM === employee.role) {
			salaryValue = Salary.PM
		}
		if (Role.DEV === employee.role) {
			salaryValue = Salary.DEV
		}
		if (Role.QA === employee.role) {
			salaryValue = Salary.QA
		}
	}
	
	console.log(padLeft(employee.name, 10), padLeft("|", 5), padLeft(location, 30), padLeft("|", 5), padLeft(country, 15), padLeft("|", 5), padLeft(salaryValue, 15))
});