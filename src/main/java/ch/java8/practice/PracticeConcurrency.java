package ch.java8.practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import ch.java8.practice.api.Concurrencable;
import ch.java8.practice.api.ScheduledConcurrencable;
import ch.java8.practice.impl.PersonSearchImpl;
import ch.java8.practice.impl.StudentSearchImpl;
import ch.java8.util.ConcurrencyUtils;

public class PracticeConcurrency {
	public static void main(String[] args) {
		System.out.println("\n-------------------Practice Concurrency-------------------");	
		executor();
		scheduledCallableExecutor();
		scheduledRunnableExecutor();
	}
	
	private static void executor() {
		System.out.println("\n-------------------Executor-------------------");	
		try {
			new StudentSearchImpl().search("John").forEach(System.out::println);
			new PersonSearchImpl().search("Stephan").forEach(System.out::println);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("termination interrupted or execution interrupted or timeout interrupted" + e);
		}
	}
	public static void scheduledCallableExecutor() {
		System.out.println("\n-------------------callable scheduled Executor-------------------");	
		Concurrencable<Long, String> concurrencable = (query) -> {
			return Long.valueOf(query);
		};
		
		try {
			System.out.println("Val " + concurrencable.scheduledInvoke("123"));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.err.println("termination interrupted or execution interrupted or timeout interrupted" + e);
		}
	}
	
	public static void scheduledRunnableExecutor() {
		System.out.println("\n-------------------runnable scheduled Executor-------------------");	
		ScheduledConcurrencable scheduledConcurrencable = () -> {
			System.out.println("Invoked " + System.currentTimeMillis());
		};
		
		scheduledConcurrencable.invoke(ConcurrencyUtils.remainingDelay(14, 44, 00));
	}
}
