package com.mapreduce.custom;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Female_survived {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {

		Configuration conf = new Configuration();

		Job job = new Job();

		job.setJarByClass(Female_survived.class);

		job.setMapperClass(Map.class);

		job.setReducerClass(Reduce.class);

		job.setOutputKeyClass(Key_value.class);

		job.setMapOutputKeyClass(Key_value.class);

		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputValueClass(IntWritable.class);

		job.setInputFormatClass(Titanic_input.class);

		job.setOutputFormatClass(TextOutputFormat.class);

		Path out = new Path(args[1]);

		out.getFileSystem(conf).delete(out);

		FileInputFormat.addInputPath(job, new Path(args[0]));

		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);

	}

	public static class Reduce extends
			Reducer<Key_value, IntWritable, Key_value, IntWritable> {

		public void reduce(Key_value key, Iterable<IntWritable> values,
				Context context)

		throws IOException, InterruptedException {

			int sum = 0;

			for (IntWritable val : values) {

				sum += val.get();

			}

			context.write(key, new IntWritable(sum));

		}

	}

	public static class Map extends
			Mapper<Key_value, Text, Key_value, IntWritable> {

		private final static IntWritable one = new IntWritable(1);

		public void map(Key_value key, IntWritable value, Context context)
				throws IOException, InterruptedException {

			context.write(key, one);

		}

	}
}
