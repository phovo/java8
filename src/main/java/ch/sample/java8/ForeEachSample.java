package ch.sample.java8;

import java.util.Arrays;
import java.util.List;

import ch.sample.bo.Student;

public class ForeEachSample {
	public static void forEach() {
		System.out.println("forEach-------------------");
		List<Student> students = Arrays.asList(new Student("FA", "LA", 1), new Student("FB", "LB", 2));
		students.forEach(s -> s.setAge(s.getAge() + 20));
		students.forEach(s -> System.out.println(s.getFirstName() + "-" + s.getLastName() + "-" + s.getAge()));
	}
}
