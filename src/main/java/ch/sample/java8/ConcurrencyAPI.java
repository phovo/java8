package ch.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class ConcurrencyAPI {
	
	
	private final static ReentrantLock lock = new ReentrantLock();
	private final static ReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final static StampedLock sLock = new StampedLock();
	static int count = 0;
	static void increment() {
		lock.lock();
		rwLock.readLock().lock();
		rwLock.writeLock().lock();
		long stamp = sLock.writeLock();
		stamp = sLock.readLock();
		try {
			count++;
		}
		finally {
			lock.unlock();
			rwLock.readLock().unlock();
			rwLock.writeLock().unlock();
			sLock.unlockWrite(stamp);
			sLock.unlockRead(stamp);
		}
	}
	
	static int val = 0;
	static void incVal() {
		lock.lock();
		try {
			val++;
		}
		finally {
			lock.unlock();
		}
	}
	
	public static void concurrencyAPI() {
		System.out.println("concurrency API-------------------");
		runnableAPI();
		executorsAPI();
		callablesAPI();
		scheduledAPI();
		lockAPI();
		atomicAPI();
	}
	
	
	private static void atomicAPI() {
		AtomicInteger atomicInt = new AtomicInteger(0);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream
			.range(1, 10000)
			.forEach(i -> executor.submit(atomicInt::incrementAndGet));
		stop(executor);
		System.out.println("Automic " + atomicInt.get());
		System.out.println(ForkJoinPool.getCommonPoolParallelism());  
	}
	
	private static void lockAPI() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(1, 10000)
			.forEach(i -> executor.submit(ConcurrencyAPI::incVal));
		stop(executor);
		System.out.println("Val: " + val);
	}
	
	private static void scheduledAPI() {
		Runnable runnable = () -> {
			System.out.println("Scheduling: " + System.currentTimeMillis());
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> scheFuture = executor.schedule(runnable, 4, TimeUnit.SECONDS);
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} 
		catch (InterruptedException e) {
			System.out.println("task interrupted " + e);
		}
		
		long remainingScheduledDelay = scheFuture.getDelay(TimeUnit.MILLISECONDS);
		System.out.println("remaining delay " + remainingScheduledDelay);
		
		System.out.println("-------------------");
		ScheduledFuture<?> scheduledFixedRateFuture = executor.scheduleAtFixedRate(runnable, 2, 1, TimeUnit.SECONDS);
		
		System.out.println("-------------------");
		ScheduledFuture<?> scheduledFixedDelayFuture = executor.scheduleWithFixedDelay(runnable, 2, 4, TimeUnit.SECONDS);
		
	}
	
	private static void callablesAPI() {
		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("First Thread: " + name);
				TimeUnit.SECONDS.sleep(1);
				name = Thread.currentThread().getName();
				System.out.println("Second Thread: " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Callable<Integer> callablesi = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				return 123;
			} 
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		ExecutorService executorRunnable = Executors.newSingleThreadExecutor();
		executorRunnable.submit(runnable);
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(callablesi);
		System.out.println("Future is Done: " + future.isDone());
		try {
			Integer result = future.get(2, TimeUnit.SECONDS);
			System.out.println("Future is Done: " + future.isDone());
			System.out.println("result: " + result);

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("task interrupted" + e);
		}
		System.out.println("Done!");
		
		Callable<Integer> task1 = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				return 2;
			} 
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		Callable<Integer> task2 = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 1;
			} 
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		Callable<Integer> task3 = () -> {
			try {
				TimeUnit.SECONDS.sleep(3);
				return 3;
			} 
			catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		System.out.println("-------------------");
		List<Callable<Integer>> callables = Arrays.asList(task1, task2, task3);
		ExecutorService executorAll = Executors.newWorkStealingPool();
		try {
			executorAll.invokeAll(callables)
						.stream()
						.map(f -> {
									try {
										return f.get();
									} 
									catch (Exception e) {
										throw new IllegalStateException(e);
									}
								})
						.collect(Collectors.toList())
						.forEach(System.out::println);
		} catch (InterruptedException e) {
			throw new IllegalStateException("task interrupted", e);
		}
		System.out.println("-------------------");
		try {
			Integer result = executorAll.invokeAny(callables);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalStateException("task interrupted", e);
		}
	}
	
	private static void executorsAPI() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String name = Thread.currentThread().getName();
			System.out.println("Thread: " + name);
			try {
				executor.shutdown();
				executor.awaitTermination(5, TimeUnit.SECONDS);
			} 
			catch (InterruptedException e) {
				System.out.println("task interrupted");
			}
			finally {
				if (!executor.isTerminated()) {
					System.out.println("cancel non-fiished task");
				}
				executor.shutdownNow();
				System.out.println("shutdown finished");
			}
		});	
	}
	
	private static void runnableAPI() {
		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("First Thread: " + name);
				TimeUnit.SECONDS.sleep(1);
				name = Thread.currentThread().getName();
				System.out.println("Second Thread: " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		runnable.run();
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("Done!");
	}
	
	@FunctionalInterface
	public interface NewCallable<V, K> {
		Callable<V> call(V task, K sleep);
	}
	
	public static void stop(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

	public static void sleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}

