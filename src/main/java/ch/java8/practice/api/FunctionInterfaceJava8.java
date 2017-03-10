package ch.java8.practice.api;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
public interface FunctionInterfaceJava8<T, U, R> {
	
	U call(T t);
	
	@SuppressWarnings("unused")
	default void declare() {
		Optional<T> type;
		OptionalInt interger;
		
		// Predicate
		Predicate<T> predicate = t -> {
			return Boolean.valueOf(t!= null);
		};
		
		BiPredicate<T, U> biPredicate = (T t, U u) -> {
			return Boolean.valueOf(t != u);
		};
		
		IntPredicate intPredicate = (int t) -> {
			return Boolean.valueOf(t!= 0);
		};
		
		// Supplier
		Supplier<T> supplier = () -> {
			T t = null;
			return t;
		};
		
		IntSupplier intSupplier = () -> {
			int t = 0;
			return t;
		};
		
		// Consumer
		Consumer<T> consumer = (T i) -> {
			
		};
		
		BiConsumer<T, U> biConsumer = (T t, U u) -> {

		};
		
		IntConsumer intConsumer = (int value) -> {
			
		};
		
		// Function
		Function<T, U> function = (T t) -> {
			U v = null;
			return v;
		};
		
		BiFunction<T, U, R> biFunction = (T t, U u) -> {
			R r = null;
			return r;
		};
		
		IntFunction<R> intFunction = (int t) -> {
			R r = null;
			return r;
		};
		
		// UnaryOperator
		UnaryOperator<T> unaryOperator = (T t) -> {
			return t;
		};
		
		IntUnaryOperator intUnaryOperator = (int t) -> {
			return t;
		};
		
		// UnaryOpeBinaryOperatorrator
		BinaryOperator<T> binaryOperator = (T t, T u) ->{
			T r = null;
			return r;
		};
		
		IntBinaryOperator intBinaryOperator = (int left, int right) -> {
			int t = 0;
			return t;
		};
		
		// Comparator
		Comparator<T> comparable = (T o1, T o2) -> {
			return 0;
		};
		
	}
}
