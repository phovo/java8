package ch.java8.workshop.java;

import java.util.Collections;

public class Helper {
	public static void showHeader() {
		System.out.println("\n" +
				  String.format("%10s", "Name") +
				  String.format("%25s", "Address") + 
				  String.format("%30s", "Country") + 
				  String.format("%15s", "Salary") + "\n" +
				  String.join("", Collections.nCopies(80, "-")));
	}
	
	public static void showContent(String name, String location, String country, String salary) {
		System.out.println(String.format("%10s", name) + String.format("%5s", "|") + 
		  String.format("%30s", location) + String.format("%5s", "|") + 
		  String.format("%15s", country) + String.format("%5s", "|") + 
		  String.format("%10s", salary));
	}
}
