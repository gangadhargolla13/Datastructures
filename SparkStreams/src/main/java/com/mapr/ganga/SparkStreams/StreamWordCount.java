/*package com.mapr.ganga.SparkStreams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import com.google.common.collect.Lists;

import scala.Tuple2;

public class StreamWordCount {
	private static final Pattern SPACE = Pattern.compile(" ");
	public static void main(String[] args) {
        if (args.length < 4) {
            System.err.println("Usage: StreamingAvg <zkQuorum> <group> <topics> <numThreads>");
            System.exit(1);
        }

        //Configure the Streaming Context
        SparkConf sparkConf = new SparkConf().setAppName("StreamingAvg").setMaster("local");

        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, new Duration(10000));

        int numThreads = Integer.parseInt(args[3]);
        Map<String, Integer> topicMap = new HashMap<String, Integer>();
        String[] topics = args[2].split(",");
        for (String topic: topics) {
            topicMap.put(topic, numThreads);
        }

        JavaPairReceiverInputDStream<String, String> messages =
                KafkaUtils.createStream(ssc, args[0], args[1], topicMap);
        JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
            public String call(Tuple2<String, String> tuple2) {
              return tuple2._2();
            }

			@Override
			public String apply(Tuple2<String, String> t) {
				// TODO Auto-generated method stub
				return null;
			}
          });

          JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String x) {
              return Lists.newArrayList(SPACE.split(x));
            }
          });

          JavaPairDStream<String, Integer> wordCounts = words.map(
            new PairFunction<String, String, Integer>() {
              public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
              }
            }).reduceByKey(new Function2<Integer, Integer, Integer>() {
              public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
              }
            });

          wordCounts.print();
          ssc.start();
          ssc.awaitTermination();
	}
	
}
*/