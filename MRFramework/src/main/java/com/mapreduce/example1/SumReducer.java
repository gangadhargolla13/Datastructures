package com.mapreduce.example1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SumReducer extends Reducer<LongWritable,Text,  Text, LongWritable> {
	private LongWritable result = new LongWritable();
	String str="";
	public void reduce( LongWritable key, Iterable<Text> values,
	Reducer<Text, LongWritable, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		System.out.println("Reducer job is started");
		long sum = 0;
		
		for (Text val : values) {
			str += val.toString();
		}
		//this.result.set(sum);
		//if (sum >= 60) {
		Text tt =new Text();
		tt.set(this.str);
		
		context.write(tt, key);
			//context.write(new Text().set(this.str)),key);
		//}
          System.out.println("Reducer job is completed");
	}
}