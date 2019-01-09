package com.mapreduce.portitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Worddriver {

    public static void main(String[] args)throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        Job job = new Job(conf,"Worddriver");
        job.setJarByClass(Worddriver.class);
        job.setMapperClass(Wordmap.class);
        job.setReducerClass(Wordreduce.class);
        job.setMapOutputKeyClass(Text.class);
        job.setPartitionerClass(Wordpartitioner.class);
        job.setNumReduceTasks(2);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0:1 );

    }

}