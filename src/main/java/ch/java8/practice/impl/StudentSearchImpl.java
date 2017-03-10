package ch.java8.practice.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import ch.java8.practice.api.Concurrencable;
import ch.java8.practice.bo.Student;
import ch.java8.practice.service.StudentServiceImpl;

public class StudentSearchImpl {
	StudentServiceImpl studentService = new StudentServiceImpl();
	
	public List<Student> search(String name) throws InterruptedException, ExecutionException, TimeoutException {
		Concurrencable<List<Student>, String> concurrencable = query -> studentService.search(query);
		return concurrencable.invoke(name);
	}
}
