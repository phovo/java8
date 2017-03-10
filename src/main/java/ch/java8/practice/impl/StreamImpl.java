package ch.java8.practice.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamImpl<T>{
	public Stream<T> streamOf(Collection<T> collection) {
		return collection == null || collection.isEmpty() ? Stream.empty() : collection.stream();
	}
	
	public Stream<T> streamOf(T[] arr) {
		return arr == null || arr.length == 0 ? Stream.empty() : Arrays.stream(arr);
	}
	
	@SuppressWarnings("unchecked")
	public Stream<T> builder(T...ts) {
		Builder<T> builder = Stream.<T>builder();
		for (T t : ts) {
			builder.add(t);
		}
		return builder.build();
	}
	
	public Stream<T> generate(T t, long maxSize) {
		return Stream.generate(() -> t).limit(maxSize);
	}
	
	public Stream<T> iterate(T t, long maxSize) {
		return Stream.iterate(t,  s -> s).limit(maxSize);
	}
	
	public Optional<T> reduce(Stream<T> s, BinaryOperator<T> accumulator) {
		return s.reduce(accumulator);
	}
	
	public T reduce(Stream<T> s,T identity, BinaryOperator<T> accumulator) {
		return s.reduce(identity, accumulator);
	}
}
