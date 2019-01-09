package com.mapr.ganga.SparkStreams;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import scala.Tuple2;

public final class JavaKafkaWordCount {
	private static final Pattern SPACE = Pattern.compile(" ");
	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setAppName("StreamingAvg").setMaster("local[*]");
		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(10000));
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put("test", 1);
		JavaPairDStream<String, String> messages = KafkaUtils.createStream(jssc, "localhost:2181", "g1", topicMap);
		JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
			private static final long serialVersionUID = 1L;
			@Override
			public String call(Tuple2<String, String> tuple2) {
				String s = tuple2._2();
				System.out.println("The values " + s);
				return s;
			}
		});

		JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Iterable<String> call(String x) {
				return Lists.newArrayList(SPACE.split(x));
			}
		});

		JavaPairDStream<String, Integer> wordCounts = words.mapToPair(new PairFunction<String, String, Integer>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Tuple2<String, Integer> call(String s) {
				System.out.println("The value is " + s);
				return new Tuple2<String, Integer>(s, 1);
			}
		}).reduceByKey(new Function2<Integer, Integer, Integer>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});
		wordCounts.print();
		jssc.start();
		jssc.awaitTermination();
	}
}
