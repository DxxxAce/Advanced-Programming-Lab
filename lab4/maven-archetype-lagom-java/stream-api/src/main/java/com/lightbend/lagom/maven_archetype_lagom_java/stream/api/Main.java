package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

/**
 * Main class.
 * @author alinh
 *
 */
public class Main {
	
	/**
	 * Main program function.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		
		City city = new City("Pascani");

		System.out.println(city.getStreets());
	}
}
