package ch.java8.practice.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ch.java8.util.ConcurrencyUtils;

@FunctionalInterface
public interface Concurrencable<T, K> {
	
	static int nThread = 2;
	
	static long delay = 3;
	
	T call(K k);
	
	default public T invoke(K k) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(nThread);
		Future<T> future = executor.submit(() -> {
			return call(k);
		});
		
		try {
			ConcurrencyUtils.sleep(5);
			return future.get(ConcurrencyUtils.TIMEOUT, TimeUnit.SECONDS);
		} 
		finally {
			ConcurrencyUtils.stop(executor);
		}
	}
	
	default public T scheduledInvoke(K k) throws InterruptedException, ExecutionException, TimeoutException {
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(nThread);
		ScheduledFuture<T> scheduledFuture = scheduledExecutor.schedule(() -> {
			return call(k);
		}, delay, TimeUnit.SECONDS);
		
		try {
			ConcurrencyUtils.sleep(5);
			return scheduledFuture.get(ConcurrencyUtils.TIMEOUT, TimeUnit.SECONDS);
		} 
		finally {
			ConcurrencyUtils.stop(scheduledExecutor);
		}
	}
}
