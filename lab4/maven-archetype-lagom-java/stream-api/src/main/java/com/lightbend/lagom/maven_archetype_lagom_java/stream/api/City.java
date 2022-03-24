package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import akka.stream.impl.fusing.Map;

public class City {

	private String name;
	private List<Intersection> intersections = new ArrayList<>();
	private LinkedList<Street> streets = new LinkedList<>();
	HashMap<Intersection, List<Street>> cityMap = new HashMap<>();
	
	public City(String name) {

		this.name = name;
		
		Random rand = new Random();
		
		var nodes = IntStream.rangeClosed(0, 9)
				 .mapToObj(i -> new Intersection("i" + i))
				 .toArray(Intersection[]::new);
		
		var edges = IntStream.rangeClosed(0,  16)
				.mapToObj(i -> new Street("s" + i, (rand.nextInt(5) + 1)))
				.toArray(Street[]::new);
		
		intersections.addAll(Arrays.asList(nodes));
		streets.addAll(Arrays.asList(edges));
		
		cityMap.put(intersection, Arrays.asList(edges[0], edges[1], edges[2]));
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public List<Intersection> getIntersections() {
	
		return intersections;
	}
	
	public String getName() {
	
		return name;
	}
	
	public LinkedList<Street> getStreets() {
	
		return streets;
	}
	
	public void sortStreets() {
		
		streets.sort(Comparator.comparing(Street::getLength));
	}
	
	public void printStreetsLongerThan(int length) {
		
		streets.stream()
		 .filter(v -> cityMap.get(v).contains(e))
		 .forEach(System.out::println);
	}
}
