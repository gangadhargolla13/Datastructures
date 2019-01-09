package com.java.core.moderate;

import java.util.HashMap;

public class BestLine {
	public static Line findBestLine(Point[] points) {
		int numPoints = points.length;
		HashMap<Line, Integer> map = new HashMap<>();
		
		/* Put lines into HashMap */
		for (int i = 0; i < numPoints - 1; i++) {
			for (int j = i + 1; j < numPoints; j++) {
				Line line = new Line(points[i], points[j]);
				System.out.println(line); // for error checking
				map.merge(line, 1, Integer::sum);
			}
		}
		
		/* Count which line is most popular */
		int max = 0;
		Line bestLine = null;
		for (Line line : map.keySet()) {
			int value = map.get(line);
			if (value >= max) {
				max = map.get(line);
				bestLine = line;
			}
		}
		return bestLine;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 16.9: Best Line\n");
		Point[] points = new Point[4];
		points[0] = new Point(1, 3);
		points[1] = new Point(2, 4);
		points[2] = new Point(3, 5);
		points[3] = new Point(13, 7);
		
		Line bestLine = BestLine.findBestLine(points);
		System.out.println("\nbestLine:  " + bestLine);
	}
}
