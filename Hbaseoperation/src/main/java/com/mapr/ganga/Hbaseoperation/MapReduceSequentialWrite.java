package com.mapr.ganga.Hbaseoperation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

public class MapReduceSequentialWrite {
	public static void main(String[] args) {
		try {
			System.out.println("The job is started successfully");
			String tableName = args[0];
			Configuration conf = HBaseConfiguration.create();
			Job job = new Job(conf);
			job.setJarByClass(MapReduceSequentialWrite.class);
			job.setJobName("SequenceFileWriter");
			Scan scan = new Scan();
			TableMapReduceUtil.initTableMapperJob(tableName, scan, MyMapper.class, BytesWritable.class,
					BytesWritable.class, job);
			job.setOutputFormatClass(SequenceFileOutputFormat.class);
			job.setOutputKeyClass(BytesWritable.class);
			job.setOutputValueClass(BytesWritable.class);
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			job.waitForCompletion(true);
			System.out.println("The job is submitted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
