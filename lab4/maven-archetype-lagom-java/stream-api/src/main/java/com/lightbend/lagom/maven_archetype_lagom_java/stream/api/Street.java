package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

public class Street {

	private String name;
	private int length;
	Intersection intersection1, intersection2;
	
	public Street(String name) {
		
		this.name = name;
	}
	
	public Street(String name, int length, Intersection intersection1, Intersection intersection2) {
		
		this.name = name;
		this.length = length;
		this.intersection1 = intersection1;
		this.intersection2 = intersection2;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setLength(int length) {
	
		this.length = length;
	}
	
	public void setIntersection1(Intersection intersection1) {
	
		this.intersection1 = intersection1;
	}
	
	public void setIntersection2(Intersection intersection2) {
	
		this.intersection2 = intersection2;
	}
	
	public String getName() {
	
		return name;
	}
	
	public int getLength() {
	
		return length;
	}
	
	public Intersection getIntersection1() {
	
		return intersection1;
	}
	
	public Intersection getIntersection2() {
		
		return intersection2;
	}
}
