package ch.java8.practice.service;

import java.util.Arrays;
import java.util.List;

import ch.java8.practice.bo.Student;

public class StudentServiceImpl {
	
	public List<Student> search(String name) {
		return Arrays.asList(new Student(name + " FA", "LA", 10),
				new Student(name + " FB", "LB", 11), 
				new Student(name + " FC", "LC", 12));
	}
}
