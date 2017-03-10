package ch.java8.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrencyUtils {
	
	public static final long TIMEOUT = 30 * 60;
	
	public static final long PERIOD = 24 * 60 * 60;
	
	public static void sleep(long timeout) throws InterruptedException {
		TimeUnit.SECONDS.sleep(timeout);
	}
	
	public static void stop(ExecutorService executor) throws InterruptedException {
		try {
			executor.shutdown();
			executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
		} 
		finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}
	
	public static long remainingDelay(int hours, int minutes, int second) {
		ZonedDateTime zonedNow = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		ZonedDateTime zonedScheduled = zonedNow.withHour(hours).withMinute(minutes).withSecond(second);
		
		if (zonedNow.compareTo(zonedScheduled) > 0) 
			zonedScheduled = zonedScheduled.plusDays(1);
		
		return Duration.between(zonedNow, zonedScheduled).getSeconds();
	}
}
