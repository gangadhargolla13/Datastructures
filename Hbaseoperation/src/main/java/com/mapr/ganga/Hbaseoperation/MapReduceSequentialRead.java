package com.mapr.ganga.Hbaseoperation;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MapReduceSequentialRead {
	public static void main(String[] args) {
		try {
			Configuration conf = HBaseConfiguration.create();
		    conf.set("tableName",args[1]);
			Job job = new Job(conf);
			job.setJarByClass(MapReduceSequentialRead.class);
			job.setJobName("SequenceFileReader");
			
			//Add input and output file paths to job based on the arguments passed
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[2]));

			job.setInputFormatClass(SequenceFileInputFormat.class);
			job.setMapperClass(SequenceFileReaderMapper.class);
			job.setNumReduceTasks(0);
			
			
			//Wait for the job to complete and print if the job was successful or not
			int returnValue = job.waitForCompletion(true) ? 0:1;
			
			if(job.isSuccessful()) {
				System.out.println("Job exis status "+returnValue);
				System.out.println("Job was successful");
			} else if(!job.isSuccessful()) {
				System.out.println("Job was not successful");			
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

