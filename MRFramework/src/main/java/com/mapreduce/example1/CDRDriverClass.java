package com.mapreduce.example1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class CDRDriverClass {

	public static void main(String[] args) throws Exception {
		System.out.println("MapReduce Testing job is started!");
        Configuration conf = new Configuration();
        if (args.length != 2) {
            System.err.println("Usage: stdsubscriber < in> < out>");
            System.exit(2);
        }
        Job job = new Job(conf, "STD Subscribers");
        job.setJarByClass(CDRDriverClass.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(SumReducer.class);
        job.setReducerClass(SumReducer.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // To set how many times job should be tried
       // JobConf cc = new JobConf();
       // cc.setMaxMapAttempts(1);
        int value = job.waitForCompletion(true) ? 0 : 1;
        if(value == 0){
        	System.out.println("MapReduce job is completed successfully");
        }
        System.exit(value);
    }
}
