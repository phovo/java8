package ch.java8.practice.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import ch.java8.practice.bo.Student;

public class CollectorsImpl {
	
	List<String> ls = Arrays.asList("aa", "bbb", "cc");
	
	List<Integer> li = Arrays.asList(11, 222, 3);
	
	List<Student> students = Arrays.asList(new Student("FA", "LA", 10), new Student("FB", "LB", 11), new Student("FC", "LC", 12), new Student("FD", "LD", 10), new Student("FB", "LB", 10));
	
	public void collect() {
		toList();
		toMap();
		joining();
		counting();
		summarizing();
		minmax();
		groupingBy();
		partitioningBy();
		peek();
	}
	
	public void toList() {
		System.out.println("-------------------toList-------------------");	
		ls.stream()
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
	
	public void toMap() {
		System.out.println("-------------------toMap-------------------");	
		Map<String, Integer> smap = ls.stream()
										.collect(Collectors.toMap(Function.identity(), String::length, (i1, i2) -> i1));
		smap.forEach((k, v) -> System.out.println(k + "-" + v));
	}
	
	public void joining() {
		System.out.println("-------------------joining-------------------");	
		System.out.println(ls.stream()
				.collect(Collectors.joining(" ", "PRE-", "-POST")));
	}
	
	public void counting() {
		System.out.println("-------------------counting-------------------");	
		System.out.println(ls.stream()
				.collect(Collectors.counting()));
	}
	
	public void summarizing() {
		System.out.println("-------------------counting-------------------");	
		System.out.println(li.stream()
				.collect(Collectors.summarizingInt(Integer::intValue)));
	}
	
	public void minmax() {
		System.out.println("-------------------minmax-------------------");	
		System.out.println("Max " + li.stream()
				.collect(Collectors.maxBy(Comparator.naturalOrder())).get());
		System.out.println("Min " + li.stream()
				.collect(Collectors.minBy(Comparator.naturalOrder())).get());
	}
	
	public void groupingBy() {
		System.out.println("-------------------groupingBy-------------------");	
		Map<String, List<String>> map = ls.stream()
				.collect(Collectors.groupingBy(String::valueOf, Collectors.toList()));
		map.forEach((k, v) -> System.out.println(k + "-" + v));
		
		Map<Integer, List<Student>> sMap = students.stream()
				.collect(Collectors.groupingBy(Student::getAge, Collectors.toList()));
		sMap.forEach((k, v) -> System.out.println(k + "-" + v));
	}
	
	public void partitioningBy() {
		System.out.println("-------------------partitioningBy-------------------");	
		Map<Boolean, List<Student>> sMap = students.stream()
													.collect(Collectors.partitioningBy(s -> s.getAge() > 10));
		sMap.forEach((k, v) -> System.out.println(k + "-" + v));
	}
	
	public void peek() {
		System.out.println("-------------------peek-------------------");	
		ls
		.stream()
		.filter(e -> e.length() > 3)
		.peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList())
        .forEach(System.out::println);
	}
}
