package ch.java8.practice.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupableImpl<K, V> {
	public Map<K, List<V>> group(List<V> ls, Function<V, K> func) {
		Supplier<Map<K, List<V>>> map = () -> {
			return ls
					.stream()
					.collect(Collectors.groupingBy(func, Collectors.toList()));
		};
		return map.get();
	}
}
