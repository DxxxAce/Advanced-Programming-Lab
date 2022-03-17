package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

public class Intersection {

	private String name;
	
	public Intersection(String name) {

		this.name = name;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public String getName() {
	
		return name;
	}
}
