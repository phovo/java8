package ch.java8.practice.api;

@FunctionalInterface
public interface Convertable<K,V> {
	K get();
}
