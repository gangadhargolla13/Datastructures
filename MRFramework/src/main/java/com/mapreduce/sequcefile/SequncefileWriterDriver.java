package com.mapreduce.sequcefile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;



public class SequncefileWriterDriver {

	public static void main(String[] args) {
		System.out.println("MapperReduce is being proccessed");
		try{
			
			if(args.length != 2){
				System.err.println("Usage : Sequence File Writer Utility <input path> <output path>");
                System.exit(-1);
			}
			Configuration conf = new Configuration();
			Job job = new Job(conf);
			job.setJarByClass(SequncefileWriterDriver.class);
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job,new Path(args[1]));
			job.setMapperClass(SequnceFileMapper.class);
			//job.setMapOutputKeyClass(Text.class);
			//job.setMapOutputValueClass(Text.class);
			job.setInputFormatClass(KeyValueTextInputFormat.class);
            job.setOutputFormatClass(SequenceFileOutputFormat.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			job.setNumReduceTasks(0);
			System.exit(job.waitForCompletion(true)?0:1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Mapreduce job is being completed");
			System.exit(-1);
		}
	}
}
