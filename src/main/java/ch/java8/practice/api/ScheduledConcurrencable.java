package ch.java8.practice.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ch.java8.util.ConcurrencyUtils;

@FunctionalInterface
public interface ScheduledConcurrencable {
	
	static int nThread = 2;
	
	void call();
	
	default public void invoke(long initialDelay) {
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(nThread);
		scheduledExecutor.scheduleAtFixedRate(() -> {
			call();
		}, initialDelay, ConcurrencyUtils.PERIOD, TimeUnit.SECONDS);
	}
}
