package ch.java8.practice;

import java.util.Arrays;
import java.util.List;

import ch.java8.practice.bo.Person;
import ch.java8.practice.bo.Student;
import ch.java8.practice.impl.ConvertableImpl;

public class PracticeConvertable {
	public static void main(String[] args) {
		System.out.println("\n-------------------Practice Converter-------------------");	
		List<Student> students = Arrays.asList(new Student("FA", "LA", 10), new Student("FB", "LB", 12), new Student("FC", "LC", 11), new Student("FD", "LD", 10));
		List<Person> persons = Arrays.asList(new Person(null, 10), new Person(null, 11), new Person(null, 12), new Person(null, 10));
		List<Person> ls = new ConvertableImpl().convert(persons, students);
		ls.forEach(System.out::println);
	}
}
