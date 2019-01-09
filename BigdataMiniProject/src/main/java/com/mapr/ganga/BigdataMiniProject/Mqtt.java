/*package com.mapr.ganga.BigdataMiniProject;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapred.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.mapreduce.Job;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import scala.Tuple2;

public class Mqtt {

	private final static String rawTableName = "csp-raw";

	@SuppressWarnings("serial")
	public static void main(String[] args) throws Exception {

		SparkConf sparkConf = new SparkConf().setAppName("SparkStreamingMqttTest").setMaster("local[4]")
				.set("spark.driver.allowMultipleContexts", "true");
		JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(10));
		int numThreads = Integer.parseInt(args[2]);
		Map<String, Integer> topicMap = new HashMap<>();
		String[] topics = args[1].split(",");
		for (String topic : topics) {
			topicMap.put(topic, numThreads);
		}
		JavaPairDStream<String,String> lines = KafkaUtils.createStream(ssc, args[0], " ", topicMap,
				StorageLevels.MEMORY_AND_DISK_SER_2);
		// 3. create connection with HBase
		Configuration config = null;
		try {
			config = HBaseConfiguration.create();
			HBaseAdmin.checkHBaseAvailable(config);
			System.out.println("HBase is running!");
		} catch (MasterNotRunningException e) {
			System.out.println("HBase is not running!");
			System.exit(1);
		} catch (Exception ce) {
			ce.printStackTrace();
		}

		config.set(TableInputFormat.INPUT_TABLE, rawTableName);

		// 4. new Hadoop API configuration
		Job newAPIJobConfiguration1 = Job.getInstance(config);
		newAPIJobConfiguration1.getConfiguration().set(TableOutputFormat.OUTPUT_TABLE, rawTableName);
		newAPIJobConfiguration1.setOutputFormatClass(org.apache.hadoop.hbase.mapreduce.TableOutputFormat.class);

		// 5. process MQTT data to save in HBase
		final Set<String> result = Collections.synchronizedSet(new HashSet<String>());
		lines.foreachRDD(new Function2() {
		}<JavaPairRDD<String<JavaPairRDD<String, String>, Void>() {

	        public Void call(JavaPairRDD<String, String> rdd) throws Exception {
	            Iterator<Tuple2<String, String>> iterator = rdd.collect().iterator();
	            while (iterator.hasNext()) {
	                result.add(iterator.next()._2);
	            }
	            return null;
	        }
	    });
		lines.foreachRDD(new Function<JavaPairRDD<String,String>, Void>() {
			@Override
			public Void call(JavaPairRDD<String,String> rdd) throws Exception {
				if (rdd.count() > 0) {
					// 6. save each RDD in HBase
					//saveToHBase(rdd, newAPIJobConfiguration1.getConfiguration());
				}
				return null;
			}
		});

		ssc.start();
		ssc.awaitTermination();
		ssc.stop();
	}

	// 6. saveToHBase method - insert data into HBase
	public static void saveToHBase(JavaRDD<Row> javaRDD, Configuration conf) throws IOException {
		// create Key, Value pair to store in HBase
		JavaPairRDD<ImmutableBytesWritable, Put> hbasePuts = javaRDD
				.mapToPair(new PairFunction<Row, ImmutableBytesWritable, Put>() {
					@Override
					public Tuple2<ImmutableBytesWritable, Put> call(Row row) throws Exception {

						Put put = new Put(Bytes.toBytes(row.getString(0)));
						put.add(Bytes.toBytes("cf1"), Bytes.toBytes("a"), Bytes.toBytes(row.getString(1)));
						put.add(Bytes.toBytes("cf1"), Bytes.toBytes("b"), Bytes.toBytes(row.getString(2)));

						return new Tuple2<ImmutableBytesWritable, Put>(new ImmutableBytesWritable(), put);
					}
				});

		// save to HBase- Spark built-in API method
		hbasePuts.saveAsNewAPIHadoopDataset(conf);
	}

}
*/