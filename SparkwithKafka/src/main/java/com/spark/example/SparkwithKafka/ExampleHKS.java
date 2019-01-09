package com.spark.example.SparkwithKafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

public class ExampleHKS 
{

	public SparkConf getConf()
	{
		SparkConf sparkConf = new SparkConf().setAppName("HKS example").setMaster("local");
		return sparkConf;
	}
	
	public JavaStreamingContext getContext()
	{
		return new JavaStreamingContext(getConf(),
				new Duration(20000));
	}
	
	public JavaPairReceiverInputDStream<String,String> getStream(String zkQ,Map<String,Integer> topic)
	{
		return KafkaUtils.createStream(getContext(), zkQ, "", topic);
	}
	public static void main(String[] args) {
		try
		{
			Configuration conf = HBaseConfiguration.create();
			ExampleHKS hks = new ExampleHKS();
			int numThreads = Integer.parseInt(args[2]);
			Map<String, Integer> topicMap = new HashMap<>();
			String[] topics = args[1].split(",");
			for (String topic : topics) {
				topicMap.put(topic, numThreads);
			}
			JavaPairReceiverInputDStream<String,String> pair = hks.getStream(args[0], topicMap);
			JavaDStream<String> stream = pair.map(records -> records._2);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
