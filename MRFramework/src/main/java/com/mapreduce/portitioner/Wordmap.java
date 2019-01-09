package com.mapreduce.portitioner;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Wordmap extends Mapper<LongWritable, Text, Text, IntWritable> {
    private final IntWritable one = new IntWritable(1);
    private Text word = new Text();
    public void map(LongWritable key,Text value,Context context)throws IOException,InterruptedException{
        String line = value.toString();
        StringTokenizer str = new StringTokenizer(line, " ");
        while (str.hasMoreTokens()) {
            word.set(str.nextToken());
            context.write(word, one);
        }
    }

}
