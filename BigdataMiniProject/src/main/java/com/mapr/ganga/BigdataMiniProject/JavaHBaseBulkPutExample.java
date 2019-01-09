/*package com.mapr.ganga.BigdataMiniProject;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.mapreduce.Job;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class JavaHBaseBulkPutExample {
	private final static String tableName = "test";
	private final static String columnFamily = "cf";

	private static JavaSparkContext sc;
	public static void main(String[] args) throws Exception{
		System.out.println("The operation is started!");
		String mode = args[0];
		sc = new JavaSparkContext(args[0], "get HBase data");
		Configuration conf = HBaseConfiguration.create();
		conf.set(TableInputFormat.INPUT_TABLE, tableName);
		Job newAPIJobConfiguration = Job.getInstance(conf);
		newAPIJobConfiguration.getConfiguration().set(TableOutputFormat.OUTPUT_TABLE, tableName);
		newAPIJobConfiguration.setOutputFormatClass(org.apache.hadoop.hbase.mapreduce.TableOutputFormat.class);
		
		Admin hBaseAdmin = null;
		try {
			Connection connection = ConnectionFactory.createConnection(conf);
			hBaseAdmin = connection.getAdmin();
			System.out.println("Checking table is exit or not");
			if (hBaseAdmin.isTableAvailable(TableName.valueOf(tableName))) {
				System.out.println("Table " + tableName + " is available.");
			}
			else {
				System.out.println("Table " + tableName + " is not available.");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			hBaseAdmin.close();
		}

		
		System.out.println("-----------------------------------------------");
		readTableJava(conf, mode);
		System.out.println("-----------------------------------------------");
		writeRowNewHadoopAPI(newAPIJobConfiguration.getConfiguration(),mode);
		System.out.println("-----------------------------------------------");
		readTableJava(conf, mode);
		System.out.println("-----------------------------------------------");
		sc.stop();

	}
	private static void readTable(Configuration conf, String mode) {
		SparkContext sc = new SparkContext(mode, "get HBase data");
		RDD<Tuple2<ImmutableBytesWritable, Result>> hBaseRDD = sc
				.newAPIHadoopRDD(
						conf,
						TableInputFormat.class,
						org.apache.hadoop.hbase.io.ImmutableBytesWritable.class,
						org.apache.hadoop.hbase.client.Result.class);
		long count = hBaseRDD.count();
		System.out.println("Number of register in hbase table: " + count);
		sc.stop();
	}
	
	
	private static void readTableJava(Configuration conf, String mode) {
		
		JavaPairRDD<ImmutableBytesWritable, Result> hBaseRDD = 
				sc
				.newAPIHadoopRDD(
						conf,
						TableInputFormat.class,
						org.apache.hadoop.hbase.io.ImmutableBytesWritable.class,
						org.apache.hadoop.hbase.client.Result.class);
		long count = hBaseRDD.count();
		System.out.println("Number of register in hbase table: " + count);
	}
	
	private static void writeRowNewHadoopAPI(Configuration conf, String mode) {
		
		JavaRDD<String> records = sc.textFile("README.md",1);
	    JavaPairRDD<ImmutableBytesWritable, Put> hbasePuts = records.mapToPair(new PairFunction<String, ImmutableBytesWritable, Put>() {
			public Tuple2<ImmutableBytesWritable, Put> call(String t)
					throws Exception {
				Put put = new Put(Bytes.toBytes("rowkey11"));
				put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes("z"),
						Bytes.toBytes("value3"));
				return new Tuple2<ImmutableBytesWritable, Put>(
						new ImmutableBytesWritable(), put);
			}
	      });
	    
		hbasePuts.saveAsNewAPIHadoopDataset(conf);
	}
}
*/