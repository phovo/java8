package ch.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import ch.java8.practice.bo.Student;
import ch.java8.practice.impl.CollectorsImpl;
import ch.java8.practice.impl.StreamImpl;

public class PracticeStream {
	
	static List<String> ls = Arrays.asList("aa", "bbb", "cc");
	
	static List<Student> students = Arrays.asList(new Student("FA", "LA", 10), new Student("FB", "LB", 11), new Student("FC", "LC", 12), new Student("FD", "LD", 10), new Student("FB", "LB", 10));
	
	public static void main(String[] args) {
		System.out.println("\n-------------------Practice Stream-------------------");	
		new CollectorsImpl().collect();
		System.out.println("-------------------streamOf Collection-------------------");	
		new StreamImpl<Student>().streamOf(students).forEach(System.out::println);
		System.out.println("-------------------streamOf Array-------------------");
		new StreamImpl<Student>().streamOf(students.stream().toArray(Student[]::new)).forEach(System.out::println);
		System.out.println("-------------------builder-------------------");
		new StreamImpl<Student>().builder(new Student("FA", "LA", 10), new Student("FB", "LB", 11)).forEach(System.out::println);
		System.out.println("-------------------generate-------------------");
		new StreamImpl<Student>().generate(new Student("FA", "LA", 10), 1).forEach(System.out::println);
		System.out.println("-------------------iterate-------------------");
		new StreamImpl<Student>().iterate(new Student("FA", "LA", 10), 1).forEach(System.out::println);
		System.out.println("-------------------reduce-------------------");
		new StreamImpl<Student>().reduce(new StreamImpl<Student>().streamOf(students),(s1, s2) -> {
			return new Student(s1.getFirstName() + "&" + s2.getFirstName(), s1.getLastName() + "&" + s2.getLastName(), s1.getAge() + s2.getAge());
		}).ifPresent(System.out::println);
		System.out.println(IntStream.range(1, 4).reduce(10, (a, b) -> a + b));
	}
}
