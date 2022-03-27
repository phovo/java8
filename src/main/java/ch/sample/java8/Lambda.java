package ch.sample.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {
	
	static Predicate<String> preValidator = (s) -> s.length() > 0;
	
	@FunctionalInterface
	interface Test {
		double sqrt(double a);
	}
	
	public static void lambda() {
		System.out.println("lambda-------------------");
		Test test = (double a) -> Math.sqrt(a);
		System.out.println(test.sqrt(5));
		
		System.out.println("-------------------");
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
		
		preValidator.negate().test("abc");
	}//
}
