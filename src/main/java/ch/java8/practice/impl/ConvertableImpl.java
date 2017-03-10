package ch.java8.practice.impl;

import java.util.List;
import java.util.stream.Collectors;

import ch.java8.practice.api.Convertable;
import ch.java8.practice.bo.Person;
import ch.java8.practice.bo.Student;

public class ConvertableImpl {
	public List<Person> convert(List<Person> persons, List<Student> students) {
		Convertable<List<Person>, List<Student>> convertable = () -> {
			persons
			 .stream()
			 .forEach(p -> {students
		 					  .stream()
		 					  .filter(s -> s.getAge() == p.getAge())
		 					  .findFirst()
		 					  .ifPresent(s -> p.setName(s.getName()));
			 });
			
			return persons
					.stream()
					.sorted((p1, p2) -> new ComparatorImpl().compare(p1, p2, false))
					.collect(Collectors.toList());
		};
		
		return convertable.get();
	}
}
