package com.lightbend.lagom.maven_archetype_lagom_java.stream.api;

import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import akka.stream.impl.fusing.Map;
import akka.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		var nodes = IntStream.rangeClosed(0, 9)
				 .mapToObj(i -> new Intersection("i" + i))
				 .toArray(Intersection[]::new);
		
		var edges = IntStream.rangeClosed(0,  16)
				.mapToObj(i -> new Street("s" + i))
				.toArray(Street[]::new);
		
		
		
		List<Intersection> intersections = new ArrayList<>();
		LinkedList<Street> streets = new LinkedList<>();

		intersections.addAll(Arrays.asList(nodes));
		streets.addAll(Arrays.asList(edges));

	}
}
