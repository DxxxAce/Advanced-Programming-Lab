package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

/**
 * Street class.
 * @author alinh
 *
 */
public class Street {

	private String name;
	private int length;
	Intersection intersection1, intersection2;
	
	/**
	 * Class constructor.
	 * @param name Street name.
	 */
	public Street(String name) {
		
		this.name = name;
	}
	
	/**
	 * Class constructor.
	 * @param name Street name.
	 * @param length Street length.
	 */
	public Street(String name, int length) {
		
		this.name = name;
		this.length = length;
	}
	
	/**
	 * Class constructor
	 * @param name Street name.
	 * @param length Street length.
	 * @param intersection1 First intersection.
	 * @param intersection2 Second intersection.
	 */
	public Street(String name, int length, Intersection intersection1, Intersection intersection2) {
		
		this.name = name;
		this.length = length;
		this.intersection1 = intersection1;
		this.intersection2 = intersection2;
	}
	
	/**
	 * Name setter.
	 * @param name Street name;
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * Length setter.
	 * @param length Street length.
	 */
	public void setLength(int length) {
	
		this.length = length;
	}
	
	/**
	 * First intersection setter.
	 * @param intersection1 First intersection.
	 */
	public void setIntersection1(Intersection intersection1) {
	
		this.intersection1 = intersection1;
	}
	
	/**
	 * Second intersection setter.
	 * @param intersection2 Second intersection.
	 */
	public void setIntersection2(Intersection intersection2) {
	
		this.intersection2 = intersection2;
	}
	
	/**
	 * Name getter.
	 * @return Street name.
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * Length getter.
	 * @return Street length.
	 */
	public int getLength() {
	
		return length;
	}
	
	/**
	 * First intersection getter.
	 * @return First intersection.
	 */
	public Intersection getIntersection1() {
	
		return intersection1;
	}
	
	/**
	 * Second intersection getter.
	 * @return Second intersection.
	 */
	public Intersection getIntersection2() {
		
		return intersection2;
	}
	
	/**
	 * Override of the toString() method.
	 * @return Street name.
	 */
	@Override
	public String toString() {

		return name;
	}
}
