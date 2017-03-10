using System.IO;
using System;
using System.Collections.Generic;
using static Employee;
using static Address;
using static Role;

class Program
{
    static List<Employee> employees = new List<Employee>()
    {
     new Employee(1, "Laura", Role.PM, new Address("Pfalzgasse 1, Zurich","Switzerland")),
     new Employee(2, "Julien",Role.DEV, new Address("Switzerland")),
     new Employee(3, "David", Role.QA, null),
     new Employee(4, "Simon", new Address("2 Rue Germain Pilon, Paris","France"))};
													
    static void Main()
    {
        Console.WriteLine("Hello, World!");
    }
}


