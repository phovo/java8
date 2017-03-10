package ch.sample.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ch.sample.bo.Bar;
import ch.sample.bo.Foo;
import ch.sample.bo.Person;
import ch.sample.bo.Student;

public class StreamSample {
	
	public static void parallelStream() {
		System.out.println("parallel Stream-------------------");
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());
		
		System.out.println("-------------------");
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	            s, Thread.currentThread().getName()));
	}
	
	public static void sequentialStream() {
		System.out.println("sequential Stream-------------------");
		List<String> ls = Arrays.asList("a1", "a2", "a3");
		ls.stream().findFirst().ifPresent(System.out::println);
		System.out.println("-------------------");
		Stream.of(ls).findAny().ifPresent(System.out::println);
		System.out.println("-------------------");
		IntStream.of(1,2,3).forEach(System.out::println);
		System.out.println("-------------------");
		IntStream.range(1, 5).forEach(System.out::println);
		System.out.println("-------------------");
		ls.stream().map(s -> s.substring(1)).mapToInt(Integer::parseInt).forEach(System.out::println);
		System.out.println("-------------------");
		ls.stream().map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
		System.out.println("-------------------");
		ls.stream().map(s -> s.substring(1) + "1").forEach(System.out::println);
		System.out.println("-------------------");
		ls.stream().map(s -> s.substring(1)).mapToInt(Integer::parseInt).filter(i -> i >= 2).forEach(System.out::println);
		
		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c") 
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("-------------------");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
	    System.out.println("-------------------");
	    List<Person> persons =
	    	    Arrays.asList(
	    	        new Person("Max", 18),
	    	        new Person("Peter", 23),

	    	        new Person("David", 12),
	    	        new Person("Pamela", 23));
	    List<Person> filtered =
	    	    persons
	    	        .stream()
	    	        .filter(p -> p.getName().startsWith("P"))
	    	        .collect(Collectors.toList());

	    System.out.println(filtered);  
	    System.out.println("-------------------");
	    Map<Integer, List<Person>> personsByAge = 
	    		persons
	    	    .stream()
	    	    .collect(Collectors.groupingBy(Person::getAge, Collectors.toList()));
	    personsByAge
	    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
	    
	    System.out.println("-------------------");
	    Double averageAge = persons
	    	    .stream()
	    	    .collect(Collectors.averagingInt(p -> p.age));
	    System.out.println(averageAge);     // 19.0
	    
	    System.out.println("-------------------");
	    IntSummaryStatistics ageSummary =
	    	    persons
	    	        .stream()
	    	        .collect(Collectors.summarizingInt(p -> p.age));
	   System.out.println(ageSummary);
	   
	   System.out.println("-------------------");
	   String phrase = persons
			    .stream()
			    .filter(p -> p.age >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
	   System.out.println(phrase);
	   
	   System.out.println("-------------------");
	   Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + ";" + name2));
	   System.out.println(map);
	   
	   System.out.println("-------------------");
	   List<Foo> foos = new ArrayList<>();

	   // create foos
	   IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));
		
	   // create bars
	   foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i))));
		
		foos.stream()
			.flatMap(f -> f.bars.stream())
			.forEach(b -> 
			System.out.println(b.name));
		
		 System.out.println("reduce-------------------");
		 Optional<Person> optional = persons.stream().reduce((p1, p2) -> new Person(p1.name  + "#"+  p2.name, p1.age + p2.age));
		 optional.ifPresent(System.out::println);
		 System.out.println("parallel Stream-------------------");
		 persons.parallelStream()
		 .map(p -> p.name)
		 .forEach(System.out::println);
		 System.out.println("parallel Stream-------------------");
	}
	
	public static void sampleStream() {
		System.out.println("sample Stream-------------------");
		List<Student> students = Arrays.asList(new Student("FA", "LA", 10), new Student("FB", "LB", 11),  new Student("FB", "LB", 11), new Student("FC", "LC", 12));
		List<Person> persons = Arrays.asList(new Person("A", 10), new Person("B", 11), new Person("C", 12), new Person("D", 13));
		System.out.println("sample Stream-------------------");
		students.stream()
				.collect(Collectors.groupingBy(s -> s.getAge()))
				.forEach((age, s) -> System.out.format("\n%s %s", age, s));
		System.out.println("\nsample Stream-------------------");
		persons.stream()
			.collect(Collectors.groupingBy(p -> {
				return students
						.stream()
						.filter(s -> s.getAge() == p.getAge())
						.findFirst();
			}))
			.forEach((age, s) -> System.out.format("\n%s %s", age, s));
		System.out.println("\nsample Stream-------------------");		
		persons.forEach(System.out::println);
		System.out.println("-------------------");
		persons.set(1, null);
		persons
			.forEach(p -> {
						 students
							.stream()
							.filter(s -> p != null && s.getAge() == p.getAge())
							.findFirst()
							.ifPresent(s -> p.setName(s.getFirstName() + " " + s.getLastName()));
			});
		
		
		persons.forEach(System.out::println);
		System.out.println("-------------------");
		List<Foo> foos = new ArrayList<>();
		// create foos
		IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));
		// create bars
		foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i))));
		
		foos.stream()
		.flatMap(f -> f.bars.stream())
		.forEach(b -> 
		System.out.println(b));
		System.out.println("-------------------");
		List<Optional<Integer>> ls = Arrays.asList(Optional.of(2), Optional.ofNullable(null), Optional.of(5));
		ls.stream()
			.flatMap(s -> Stream.of(s))
			.forEach(s -> s.ifPresent(v -> System.out.println(v)));
		
	}
}
