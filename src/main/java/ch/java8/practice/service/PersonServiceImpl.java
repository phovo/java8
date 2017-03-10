package ch.java8.practice.service;

import java.util.Arrays;
import java.util.List;

import ch.java8.practice.bo.Person;

public class PersonServiceImpl {
	public List<Person> search(String name) {
		return Arrays.asList(new Person(name + " PA", 10),
				new Person(name + " PB", 11), 
				new Person(name + " PC", 12));
	}
}
