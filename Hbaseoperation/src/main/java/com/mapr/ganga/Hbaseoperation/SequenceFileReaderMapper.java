package com.mapr.ganga.Hbaseoperation;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SequenceFileReaderMapper extends Mapper<BytesWritable, BytesWritable, Text, Text> {
	protected void map(BytesWritable key, BytesWritable value, Context context)
			throws IOException, InterruptedException {
		Configuration c = context.getConfiguration();
		Connection connection = ConnectionFactory.createConnection(c);
		String s = c.get("tableName");
		TableName tableName = TableName.valueOf(s);
	    Table table = connection.getTable(tableName);
	    System.out.println("The job is started");
	    Get g = new Get(value.getBytes());
        Result result = table.get(g);
        if( result != null)
        {
        	System.out.println("Row id"+result.getRow());
        }
	}
}