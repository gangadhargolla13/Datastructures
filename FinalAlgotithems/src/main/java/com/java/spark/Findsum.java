package com.java.spark;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Findsum {

	public static void main(String[] args) {
		String fileName = "C:/ganga-codebase/india.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			// stream.map(line -> Arrays.stream(line.split(" "))).map(f ->
			// f.filter(w -> w.contains("a"))).forEach(System.out::println);
			// stream.flatMap(line -> Arrays.stream(line.split(" "))).filter(m
			// -> m.contains("a")).forEach(System.out::println);

			// List<Integer> lll = stream.flatMap(line ->
			// Arrays.stream(line.split(" "))).filter(m ->
			// Character.isDigit(m.charAt(0))).map(l ->
			// Integer.parseInt(l)).collect(Collectors.toList());
			// System.out.println(lll);
			/*
			 * long w = stream.flatMap(line ->
			 * Arrays.stream(line.split(" "))).distinct().count();
			 * System.out.println(w);
			 */
			/*
			 * stream.map(s ->
			 * s.split(" ")).collect(Collectors.toList()).listIterator().next();
			 * List<String[]> l = stream.map(s ->
			 * s.split(" ")).collect(Collectors.toList()); for(String[] ss : l)
			 * { System.out.println(ss.length); }
			 */
			// stream.map(s -> s.split("
			// ")).collect(Collectors.toList()).stream().filter(word ->
			// word.contains("a")).forEach(System.out::println);;

			/*
			 * Path path = Paths.get(fileName); Map<String, Long> wordCount =
			 * Files.lines(path).flatMap(line ->
			 * Arrays.stream(line.trim().split(" "))) .map(word ->
			 * word.toLowerCase().trim()) .filter(word -> word.contains("a"))
			 * .map(word -> new SimpleEntry<>(word, 1)) .collect(toMap(e ->
			 * e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));
			 * 
			 * wordCount.forEach((k, v) ->
			 * System.out.println(String.format("%s ==>> %d", k, v)));
			 */

			Path path = Paths.get(fileName);
			Map<String, Integer> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
					.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
					.filter(word -> word.length() > 0).map(word -> new SimpleEntry<>(word, 1))
					.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
					.reduce(new LinkedHashMap<>(), (acc, entry) -> {
						acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
						return acc;
					}, (m1, m2) -> m1);

			wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
