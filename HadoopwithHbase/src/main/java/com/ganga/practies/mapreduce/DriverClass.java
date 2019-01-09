package com.ganga.practies.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class DriverClass {

	public void jobsubmit() throws IOException,InterruptedException,ClassNotFoundException{
		System.out.println("mapreduce job is being ran");
		Configuration conf = new Configuration();
		Job job = new Job(conf);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		job.setMapperClass(TestMapper.class);
		job.setReducerClass(TestReducer.class);
		job.submit();
		int status = job.waitForCompletion(true)?0:1;
		System.exit(status);
		System.out.println("mapreduce job is completed successfully");
	}
}
