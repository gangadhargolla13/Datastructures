/*package com.mapr.ganga.BigdataMiniProject;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapred.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.rdd.RDD;

import scala.Tuple2;
public class SparkToHBase {
	
	private final static String tableName = "test";
	private final static String columnFamily = "cf";

	private static JavaSparkContext sc;
	public static void main(String[] args) throws Exception{
		String mode = args[0];
		sc = new JavaSparkContext(args[0], "get HBase data");
		Configuration conf = HBaseConfiguration.create();
		conf.set(TableInputFormat.INPUT_TABLE, tableName);
		
		// new Hadoop API configuration
		Job newAPIJobConfiguration = Job.getInstance(conf);
		FileOutputFormat.setOutputPath(newAPIJobConfiguration, new Path(args[1]));
		newAPIJobConfiguration.getConfiguration().set(TableOutputFormat.OUTPUT_TABLE, tableName);
		newAPIJobConfiguration.setOutputFormatClass(org.apache.hadoop.hbase.mapreduce.TableOutputFormat.class);
		
		// old Hadoop API configuration
		JobConf oldAPIJobConfiguration = new JobConf(conf, SparkToHBase.class);
		oldAPIJobConfiguration.setOutputFormat(TableOutputFormat.class);
		oldAPIJobConfiguration.set(TableOutputFormat.OUTPUT_TABLE, tableName);
		
		
		
		HBaseAdmin hBaseAdmin = null;
		try {
			hBaseAdmin = new HBaseAdmin(conf);
			if (hBaseAdmin.isTableAvailable(tableName)) {
				System.out.println("Table " + tableName + " is available.");
			}
			else {
				System.out.println("Table " + tableName + " is not available.");
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			hBaseAdmin.close();
		}

		
		System.out.println("-----------------------------------------------");
		//readTable(conf, mode);
		readTableJava(conf, mode);
		System.out.println("-----------------------------------------------");
		//writeRowOldHadoopAPI(oldAPIJobConfiguration,mode);
		writeRowNewHadoopAPI(newAPIJobConfiguration.getConfiguration(),mode);
		System.out.println("-----------------------------------------------");
		readTableJava(conf, mode);
		System.out.println("-----------------------------------------------");
		//System.exit(0);
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
//		sc.stop();
	}
	
	private static void writeRowOldHadoopAPI(JobConf conf, String mode) {
		//JavaSparkContext sparkContext = new JavaSparkContext(mode, "write data to HBase");
		//FIXME: mirar como quitar la carga de un texto arbitrario para crear un JavaRDD
		JavaRDD<String> records = sc.textFile("README.md",1);
		
	    JavaPairRDD<ImmutableBytesWritable, Put> hbasePuts = records.mapToPair(new PairFunction<String, ImmutableBytesWritable, Put>() {
			public Tuple2<ImmutableBytesWritable, Put> call(String t)
					throws Exception {
				Put put = new Put(Bytes.toBytes("rowkey12"));
				put.add(Bytes.toBytes(columnFamily), Bytes.toBytes("z"),
						Bytes.toBytes("value3"));

				return new Tuple2<ImmutableBytesWritable, Put>(
						new ImmutableBytesWritable(), put);
			}
	      });
		hbasePuts.saveAsHadoopDataset(conf);
		//sparkContext.stop();

	}
	
	private static void writeRowNewHadoopAPI(Configuration conf, String mode) {
	
		JavaRDD<String> records = sc.textFile("README.md",1);
	    JavaPairRDD<ImmutableBytesWritable, Put> hbasePuts = records.mapToPair(new PairFunction<String, ImmutableBytesWritable, Put>() {
			public Tuple2<ImmutableBytesWritable, Put> call(String t)
					throws Exception {
				Put put = new Put(Bytes.toBytes("rowkey11"));
				put.add(Bytes.toBytes(columnFamily), Bytes.toBytes("z"),
						Bytes.toBytes("value3"));

				return new Tuple2<ImmutableBytesWritable, Put>(
						new ImmutableBytesWritable(), put);
			}
	      });
		hbasePuts.saveAsNewAPIHadoopDataset(conf);
		//sparkContext.stop();

	}

}
*/