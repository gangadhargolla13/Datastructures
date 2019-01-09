package com.ganga.ericsson.HadoopwithHbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobID;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;

public class Driverclass {

	public static void main(String[] args) {
		try {
			if(args.length == 2){
			
			System.out.println(Thread.currentThread().getName());
			Configuration config = HBaseConfiguration.create();
			config.set(HConstants.ZOOKEEPER_QUORUM, "vmy1739");
			config.set(HConstants.ZOOKEEPER_CLIENT_PORT, "5181");
			config.set("tablename",args[0]);
			Job job = new Job(config, "Reading details of table values");
			job.setJarByClass(Driverclass.class);
			JobID id =new JobID("Gangadhar", 11162);
			job.setJobID(id);
			job.setMapperClass(HbaseMapperClass.class);
			Scan scanObj = new Scan();
			scanObj.setCaching(5);
			TableMapReduceUtil.initTableMapperJob(args[0], scanObj, HbaseMapperClass.class, IntWritable.class, Text.class, job);
			job.setNumReduceTasks(0);
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			job.waitForCompletion(true);
			}else{
				System.out.println("Please pass required table name and outputdirectory");
			}
		} catch (Exception e) {
              System.out.println("Problem is occured while testing application");
              e.printStackTrace();
		}
	}
}
