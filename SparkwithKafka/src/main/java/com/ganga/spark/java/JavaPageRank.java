package com.ganga.spark.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.SparkSession;
import org.spark_project.guava.collect.Iterables;

import scala.Tuple2;

public class JavaPageRank {
	private static final Pattern SPACES = Pattern.compile("\\s+");

	private static class Sum implements Function2<Double, Double, Double> {
	    @Override
	    public Double call(Double a, Double b) {
	      return a + b;
	    }
	  }
	public static void main(String[] args) {
		String path ="C://HadoopStack//SparkwithKafka//src//main//resource//pagerank.txt";
		SparkSession spark = SparkSession
			      .builder()
			      .master("local")
			      .appName("JavaPageRank")
			      .getOrCreate();
		JavaRDD<String> lines = spark.read().textFile(path).javaRDD();
		JavaPairRDD<String, Iterable<String>> links = lines.mapToPair(s -> {
		      String[] parts = SPACES.split(s);
		      return new Tuple2<>(parts[0], parts[1]);
		    }).distinct().groupByKey().cache();
		JavaPairRDD<String, Double> ranks = links.mapValues(rs -> 1.0);
		for (int current = 0; current < Integer.parseInt("5"); current++) {
		      JavaPairRDD<String, Double> contribs = links.join(ranks).values()
		        .flatMapToPair(s -> {
		          int urlCount = Iterables.size(s._1());
		          List<Tuple2<String, Double>> results = new ArrayList<>();
		          for (String n : s._1) {
		            results.add(new Tuple2<>(n, s._2() / urlCount));
		          }
		          return results.iterator();
		        });
		      ranks = contribs.reduceByKey(new Sum()).mapValues(sum -> 0.15 + sum * 0.85);
	    }

	    List<Tuple2<String, Double>> output = ranks.collect();
	    for (Tuple2<?,?> tuple : output) {
	      System.out.println(tuple._1() + " has rank: " + tuple._2() + ".");
	    }

	    spark.stop();
	}
}
