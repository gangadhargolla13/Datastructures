package com.mapreduce.portitioner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Wordpartitioner extends Partitioner<Text, IntWritable> {
    String partititonkey;
    @Override
    public int getPartition(Text key, IntWritable value, int numPartitions) {
        // TODO Auto-generated method stub
        
        if(numPartitions == 2){
            String partitionKey = key.toString();
            if(partitionKey.charAt(0) > 'a' )
                return 0;
            else 
                return 1;
        } else if(numPartitions == 1)
            return 0;
        else{
            System.err.println("WordCountParitioner can only handle either 1 or 2 paritions");
            return 0;
        }
    }

}
