package ch.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ch.java8.practice.bo.Student;
import ch.java8.practice.impl.GroupableImpl;

public class PracticeGroupable {
	
	static List<Student> students = Arrays.asList(new Student("FA", "LA", 10), new Student("FB", "LB", 11), new Student("FC", "LC", 12), new Student("FD", "LD", 10), new Student("FB", "LB", 10));
	
	public static void main(String[] args) {
		System.out.println("\n-------------------Practice Groupable-------------------");	
		ageGroupable();
		nameGroupable();
	}

	private static void nameGroupable() {
		System.out.println("---------Groupable Name----------");	
		Map<String, List<Student>> studentNameMap = new GroupableImpl<String, Student>().group(students, Student::getName);
		studentNameMap.forEach((name, ls) -> {
			System.out.println("-------------------");
			System.out.println("Name: " + name);
			ls
			.stream()
			.sorted((s1, s2) -> s1.getFirstName().compareToIgnoreCase(s2.getFirstName()))
			.forEach(System.out::println);
		});
	}

	private static void ageGroupable() {
		System.out.println("---------Groupable Age----------");
		Map<Integer, List<Student>> studentMap = new GroupableImpl<Integer, Student>().group(students, Student::getAge);
		studentMap.forEach((age, ls) -> {
			System.out.println("-------------------");
			System.out.println("Age: " + age);
			ls
			.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
			.forEach(System.out::println);
		});
	}
}
