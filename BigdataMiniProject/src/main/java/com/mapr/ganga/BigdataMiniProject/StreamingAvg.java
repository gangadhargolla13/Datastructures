package com.mapr.ganga.BigdataMiniProject;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import scala.Tuple2;


public class StreamingAvg {
   // static Logger log = Logger.getLogger(StreamingAvg.class.getName());

    public static void main(String[] args) throws InterruptedException {
        if (args.length < 4) {
            System.err.println("Usage: StreamingAvg <zkQuorum> <group> <topics> <numThreads>");
            System.exit(1);
        }
        //setStreamingLogLevels();

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


        System.out.println("Got my DStream! connecting to zookeeper "+ args[0] + " group " + args[1] + " topics" +
        topicMap);



        JavaPairDStream<Integer,Integer> nums = messages.mapToPair(new PairFunction<Tuple2<String,String>, Integer, Integer>()
        {
            public Tuple2<Integer,Integer> call(Tuple2<String, String> tuple2) {
                return new Tuple2<Integer,Integer>(1,Integer.parseInt(tuple2._2()));
            }
        });

        JavaDStream<Tuple2<Integer,Integer>> countAndSum = nums.reduce(new Function2<Tuple2<Integer,Integer>, Tuple2<Integer,Integer>, Tuple2<Integer,Integer>>() {
            public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> a, Tuple2<Integer, Integer> b) {
                return new Tuple2<Integer, Integer>(a._1() + b._1(), a._2() + b._2());
            }
        });

        /*countAndSum.foreachRDD(new VoidFunction<JavaRDD<Tuple2<Integer, Integer>>>() {
            *//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;
			@Override
			public void call(JavaRDD<Tuple2<Integer, Integer>> tuple2JavaRDD) throws Exception {
				if (tuple2JavaRDD.count() > 0) {
                    System.out.println("Current avg: " + tuple2JavaRDD.first()._2() / tuple2JavaRDD.first()._1());
                } else {
                    System.out.println("Got no data in this window");
                }
				
			}
        });*/

        ssc.start();
        ssc.awaitTermination();

    }

    /*public static void setStreamingLogLevels() {
        Boolean log4jInitialized = Logger.getRootLogger().getAllAppenders().hasMoreElements();
        if (!log4jInitialized) {
            // We first log something to initialize Spark's default logging, then we override the
            // logging level.
            log.info("Setting log level to [WARN] for streaming example." +
                    " To override add a custom log4j.properties to the classpath.");
            Logger.getRootLogger().setLevel(Level.WARN);
        }
    }*/
}
