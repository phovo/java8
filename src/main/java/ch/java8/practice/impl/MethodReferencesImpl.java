package ch.java8.practice.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch.java8.practice.bo.User;
import ch.java8.practice.bo.UserRole;

public class MethodReferencesImpl {
	
	static List<User> users = Arrays.asList(new User("A", UserRole.ADMIN), new User("B", UserRole.USER));
	
	public void referToStaticMethod() {
		System.out.println("-------------------refer To Static Method-------------------");	
		System.out.println("Contained nullable value: " +
							users
								.stream()
								.anyMatch(Reference::isNull));
	}
	
	public void referToInstanceMethod() {
		System.out.println("-------------------refer To Instance Method-------------------");	
		users
			.stream()
			.filter(User::isAdmin)
			.filter(s -> s.getRole() == UserRole.ADMIN)
			.map(Reference::streamOf)
			.filter(Reference::isNotNull)
			.map(Reference::optionalOf)
			.flatMap(s -> s.get())
			.peek(s -> System.out.println("value at peek " + s))
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}

@FunctionalInterface
interface Reference <T>{
	
	void refer(T t);

	default public Stream<T> toStreamOf(T t) {
		return Stream.generate(() -> t).limit(10);
	}
	
	default public Stream<T> streamOf(Collection<T> collection) {
		return collection.stream();
	}
	
	public static <T> Stream<T> streamOf(T t) {
		long maxSize = 10;
		return isNull(t) ? Stream.empty() : Stream.generate(() -> t).limit(maxSize);
	}
	
	static <T> Optional<T> optionalOf(T t) {
		return isNull(t) ? Optional.ofNullable(t) : Optional.of(t);
	}
	
	static <T> boolean isNull(T t) {
		return t == null;
	}
	
	static <T> boolean isNotNull(T t) {
		return t != null;
	}
}
