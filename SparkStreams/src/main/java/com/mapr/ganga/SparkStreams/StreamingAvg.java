package com.mapr.ganga.SparkStreams;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
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

public class StreamingAvg {
	static Logger log = Logger.getLogger(StreamingAvg.class.getName());

	public static void main(String[] args) {
		//setStreamingLogLevels();
		PropertyConfigurator.configure("C:/Ericsson-Softwares/spark-1.5.1-bin-hadoop2.3/conf/log4j.properties");
		SparkConf sparkConf = new SparkConf().setAppName("StreamingAvg").setMaster("local[*]");
		JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, new Duration(10000));
		
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		topicMap.put("test", 2);
		JavaPairReceiverInputDStream<String, String> messages = KafkaUtils.createStream(ssc, "localhost:2181", "g2",
				topicMap);
		JavaPairDStream<Integer, Integer> nums = messages
				.mapToPair(new PairFunction<Tuple2<String, String>, Integer, Integer>() {
					private static final long serialVersionUID = 1L;

					public Tuple2<Integer, Integer> call(Tuple2<String, String> tuple2) {
						System.out.println("The first value is "+tuple2._1+" the second value is "+tuple2._2);
						return new Tuple2<Integer, Integer>(1, Integer.parseInt(tuple2._2()));
					}
				});
		
		JavaDStream<Tuple2<Integer, Integer>> countAndSum = nums
				.reduce(new Function2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Tuple2<Integer, Integer>>() {

					private static final long serialVersionUID = 1L;

					public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> a, Tuple2<Integer, Integer> b) {
						System.out.println("The a._1() + b._1() "+a._1+","+b._1);
						System.out.println("The a._2() + b._2() "+a._2+","+b._2);
						return new Tuple2<Integer, Integer>(a._1() + b._1(), a._2() + b._2());
					}
				});

		countAndSum.foreachRDD(new Function<JavaRDD<Tuple2<Integer, Integer>>, Void>() {

			private static final long serialVersionUID = 1L;

			public Void call(JavaRDD<Tuple2<Integer, Integer>> tuple2JavaRDD) throws Exception {
				if (tuple2JavaRDD.count() > 0) {
					System.out.println("Current avg: " + tuple2JavaRDD.first()._2() / tuple2JavaRDD.first()._1());
				} else {
					System.out.println("Got no data in this window");
				}
				return null;
			}
		});

		ssc.start();
		ssc.awaitTermination();
	}

	static void setStreamingLogLevels() {
		Boolean log4jInitialized = Logger.getRootLogger().getAllAppenders().hasMoreElements();
		if (!log4jInitialized) {
			log.info("Setting log level to [WARN] for streaming example."
					+ " To override add a custom log4j.properties to the classpath.");
			Logger.getRootLogger().setLevel(Level.WARN);
		}
	}
}
