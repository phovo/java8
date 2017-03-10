package ch.java8.practice.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import ch.java8.practice.api.Concurrencable;
import ch.java8.practice.bo.Person;
import ch.java8.practice.service.PersonServiceImpl;

public class PersonSearchImpl {
	PersonServiceImpl personService = new PersonServiceImpl();
	
	public List<Person> search(String name) throws InterruptedException, ExecutionException, TimeoutException {
		Concurrencable<List<Person>, String> concurrencable = query -> personService.search(query);
		return concurrencable.invoke(name);
	}
}
