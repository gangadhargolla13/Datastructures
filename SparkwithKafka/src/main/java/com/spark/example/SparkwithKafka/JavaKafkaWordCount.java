package com.spark.example.SparkwithKafka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import scala.Tuple2;

public class JavaKafkaWordCount {

	private static final FlatMapFunction<String, String> WORDS_EXTRACTOR = new FlatMapFunction<String, String>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Iterable<String> call(String s) throws Exception {
			return Arrays.asList(s.split(" "));
		}
	};

	private static final PairFunction<String, String, Integer> WORDS_MAPPER = new PairFunction<String, String, Integer>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Tuple2<String, Integer> call(String s) throws Exception {
			System.out.println("value of s is " + s);
			return new Tuple2<String, Integer>(s, 1);
		}
	};

	private static final Function2<Integer, Integer, Integer> WORDS_REDUCER = new Function2<Integer, Integer, Integer>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Integer call(Integer a, Integer b) throws Exception {
			// System.out.println("value of a is "+a);
			// System.out.println("value of b is "+b);
			System.out.println("value of s is " + a);
			return a + b;
		}
	};

	private JavaKafkaWordCount() {
	}

	public static void main(String[] args) throws Exception {
		System.out.println("First time running Spark with kafka example!");
		if (args.length < 3) {
			System.err
					.println("Usage: JavaKafkaWordCount <zkQuorum> <group> <topics> <numThreads>");
			System.exit(1);
		}

		// StreamingExamples.setStreamingLogLevels();
		SparkConf sparkConf = new SparkConf().setAppName("JavaKafkaWordCount")
				.setMaster("local");
		// Create the context with 2 seconds batch size
		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf,
				new Duration(20000));

		int numThreads = Integer.parseInt(args[2]);
		Map<String, Integer> topicMap = new HashMap<>();
		String[] topics = args[1].split(",");
		for (String topic : topics) {
			topicMap.put(topic, numThreads);
		}

		JavaPairReceiverInputDStream<String, String> messages = KafkaUtils
				.createStream(jssc, args[0], "", topicMap);

		JavaDStream<String> lines = messages
				.map(new Function<Tuple2<String, String>, String>() {
					private static final long serialVersionUID = 1L;

					@Override
					public String call(Tuple2<String, String> tuple2) {
						return tuple2._2;
					}
				});
		System.out.println("method is called");
		JavaDStream<String> words = lines.flatMap(WORDS_EXTRACTOR);

		JavaPairDStream<String, Integer> wordCounts = words
				.mapToPair(WORDS_MAPPER);
		JavaPairDStream<String, Integer> wordReduce = wordCounts
				.reduceByKey(WORDS_REDUCER);
		System.out.println("method is called");
		wordReduce.print();
		jssc.start();
		jssc.awaitTermination();
	}
}
