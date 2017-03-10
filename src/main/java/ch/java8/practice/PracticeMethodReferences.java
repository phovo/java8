package ch.java8.practice;

import ch.java8.practice.impl.MethodReferencesImpl;

public class PracticeMethodReferences {
	
	public static void main(String[] args) {
		MethodReferencesImpl methodReferences = new MethodReferencesImpl();
		System.out.println("\n-------------------Practice Method References-------------------");	
		methodReferences.referToStaticMethod();
		methodReferences.referToInstanceMethod();
	}
}
