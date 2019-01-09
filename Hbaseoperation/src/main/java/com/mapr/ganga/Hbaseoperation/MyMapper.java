package com.mapr.ganga.Hbaseoperation;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.io.BytesWritable;

import com.mapr.org.apache.hadoop.hbase.util.Bytes;

public class MyMapper extends TableMapper<BytesWritable, BytesWritable> {
	public void map(ImmutableBytesWritable rowKey, Result columns, Context context)
			throws IOException, InterruptedException {
		byte[] v=columns.getValue(Bytes.toBytes("d"), Bytes.toBytes("ci"));
       context.write(new BytesWritable(v), new BytesWritable(columns.getRow()));
	}
}
