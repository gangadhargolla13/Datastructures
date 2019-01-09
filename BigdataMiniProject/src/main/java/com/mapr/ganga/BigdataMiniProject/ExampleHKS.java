/*package com.mapr.ganga.BigdataMiniProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
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
			Connection connection = ConnectionFactory.createConnection(conf);
			Table table = connection.getTable(TableName.valueOf("Gangadhar"));
			ExampleHKS hks = new ExampleHKS();
			int numThreads = Integer.parseInt(args[2]);
			Map<String, Integer> topicMap = new HashMap<>();
			String[] topics = args[1].split(",");
			for (String topic : topics) {
				topicMap.put(topic, numThreads);
			}
			JavaPairReceiverInputDStream<String,String> pair = hks.getStream(args[0], topicMap);
			JavaDStream<String> stream = pair.map(records -> records._2);
			pair.foreachRDD(rdd -> rdd.mapToPair());
			JavaDStream<String> s2= stream.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
			s2.mapToPair(f);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
*/