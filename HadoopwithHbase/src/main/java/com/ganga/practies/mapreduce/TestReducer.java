package com.ganga.practies.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TestReducer extends Reducer<Text, Text, Text, FloatWritable> {
	
	public void reduce(Text key, Iterable<Text> value,Context context) throws IOException,InterruptedException{
		String outKey = null;
		long min =2000;
		long outvalue;
        for(Text rvalue : value){
        	String[] spiltvalue = rvalue.toString().split("_");
        	outKey = spiltvalue[0];
        	outvalue = new Long(spiltvalue[1]).longValue();
        	if(outvalue < min){
        		min = outvalue;
        	}
        }
        Text string = new Text(outKey);
        context.write(string, new FloatWritable(min));
        
	}
}
