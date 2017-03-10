package ch.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ch.java8.practice.bo.Address;
import ch.java8.practice.bo.UserRole;
import ch.java8.practice.bo.User;

public class PracticeOptional {
	static List<User> users = Arrays.asList(new User("A", UserRole.ADMIN, new Address("12a", "Kin")),
											new User("C", UserRole.ADMIN, new Address("12c")), 
											new User("B", UserRole.USER),
											null);
	
	public static void main(String[] args) {
		userOptional(new User("D", UserRole.ADMIN));
		usersOptional(users);
		userOptionals(users);

		userOptOptional(Optional.ofNullable(new User("A", UserRole.ADMIN, new Address("12a", "Kin"))));
		userOptOptional(Optional.ofNullable(new User("D", UserRole.ADMIN)));
		userOptOptional(Optional.ofNullable(null));
	}
	
	public static void userOptional(User user) {
		System.out.println("---------userOptional----------");
		Optional<User> userOpt = Optional.ofNullable(user);
		String street = userOpt
							.map(User::getAddress)
							.map(Address::getStreet)
							.orElseGet(() -> "N/A");
		System.out.println("Street " + street);	
	}
	
	public static void usersOptional(List<User> users) {
		System.out.println("---------usersOptional----------");
		for (User user : users) {
				String addr = Optional.ofNullable(user)
										.map(User::getAddress)
										.map(Address::getStreet)
										.orElse("N/A");
				System.out.println(addr);
		}
	}
	
	public static void userOptionals(List<User> users) {
		System.out.println("---------userOptionals----------");
		List<String> streets = users
								.stream()
								.map(Optional::ofNullable)
								.map(usr -> usr.map(User::getAddress))
								.map(addr -> addr.map(Address::getStreet))
								.map(str -> str.orElse("N/A"))
								.collect(Collectors.toList());
		System.out.println("Streets " + streets);	
	}
	
	public static void userOptOptional(Optional<User> userOpt) {
		System.out.println("---------userOptOptional----------");
		String street = 
					Optional.ofNullable(userOpt)
					.flatMap(usrOptOpt -> usrOptOpt)
					.map(User::getAddress)
					.map(Address::getStreet)
					.orElse("N/A");
		System.out.println("Street " + street);	
	}
}
