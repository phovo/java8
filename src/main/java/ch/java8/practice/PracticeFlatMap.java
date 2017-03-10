package ch.java8.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ch.java8.practice.bo.Address;
import ch.java8.practice.bo.UserRole;
import ch.java8.practice.bo.User;

public class PracticeFlatMap {
	static List<User> users = Arrays.asList(new User("A", UserRole.ADMIN, new Address("12a", "Kin"), new HashSet<Address>(Arrays.asList(new Address("1", "Ja 1"), new Address("1", "Ja 1"), new Address("2", "Ja 2")))),
			new User("A", UserRole.ADMIN, new Address("12a", "Kin")),
			new User("C", UserRole.ADMIN, new Address("12c")), 
			new User("B", UserRole.USER), null);
	
	static List<User> userRoles = Arrays.asList(new User("A", new HashSet<UserRole>(Arrays.asList(UserRole.ADMIN, UserRole.USER))), 
												new User("A", new HashSet<UserRole>(Arrays.asList(UserRole.ADMIN, UserRole.USER))));
	
	static String[][] str2dArr = new String[][] {{"11", "12", "13"}, {"21", "22", "23"}, {"31", "32", "33"}};
	
	static int[] intArr = new int[] {120, 123, 124, 125};
	
	public static void main(String[] args) {
		flatMapWithString2DArray();
		flatMapWithSet();
		flatMapToIntWithPrimitive();
	}
	
	public static void flatMapWithString2DArray() {
		System.out.println("---------flatMap With String [][]----------");
		Stream<String[]> strArr = Arrays.stream(str2dArr);
		List<Integer> ls = strArr
							.flatMap(arr -> Arrays.stream(arr))
							.peek(str -> System.out.println("peek " + str))
							.map(Integer::valueOf)
							.filter(i -> i> 20)
							.collect(Collectors.toList());
		System.out.println(ls);
	}
	
	public static void flatMapWithSet() {
		System.out.println("---------flatMap With Set----------");
		List<Address> ls = users.subList(0, 1)
				.stream()
				.flatMap(usr -> usr.getHistory().stream())
				.peek(str -> System.out.println("peek " + str))
				.distinct()
				.collect(Collectors.toList());
		System.out.println(ls);
		
		System.out.println("-------------------");
		
		List<UserRole> roles = userRoles
				.stream()
				.flatMap(usr -> usr.getRoles().stream())
				.peek(str -> System.out.println("peek " + str))
				.distinct()
				.collect(Collectors.toList());
		System.out.println(roles);
		
	}
	
	public static void flatMapToIntWithPrimitive() {
		System.out.println("---------flatMap With Primitive----------");
		
		Stream<int[]> strArr = Stream.of(intArr);
		IntStream intStream = 
				strArr
				.flatMapToInt(i -> Arrays.stream(i))
				.peek(str -> System.out.println("peek " + str));
		intStream.forEach(System.out::println);
		
		System.out.println("-------------------");
		IntStream arrStream = Arrays.stream(intArr);
		arrStream.forEach(System.out::println);
		
	}
}
