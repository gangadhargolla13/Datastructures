package com.ganga.practies.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TestMapper extends Mapper<LongWritable, Text, Text, Text>{

	public void map(LongWritable write,Text text,Context context) throws IOException,InterruptedException{
		System.out.println("Mapper job is being executed");
		StringTokenizer tiken = new StringTokenizer(text.toString(),"\\s");
		String year = tiken.nextToken();
		tiken.nextToken();
		tiken.nextToken();
		String delta = tiken.nextToken();
		context.write(new Text("Summary"), new Text(year+"_"+delta));
	}
}
