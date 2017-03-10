package ch.java8.practice.impl;

import java.util.Comparator;

import ch.java8.practice.bo.Person;

public class ComparatorImpl {
	private Comparator<Person> comparator = (p1, p2) -> {
		return p1.getName().compareTo(p2.getName());
	};
	
	public int compare(Person p1, Person p2, boolean reverse) {
		if (reverse) {
			return comparator.reversed().compare(p1, p2);
		}
		return comparator.compare(p1, p2);
	}
}
