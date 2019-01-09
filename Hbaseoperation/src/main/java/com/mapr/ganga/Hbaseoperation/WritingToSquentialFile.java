package com.mapr.ganga.Hbaseoperation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Writer;

public class WritingToSquentialFile 
{

	public static void main(String[] args) 
	{
		try
		{
			System.out.println("Operation is started!");
			SequenceFile.Writer writer = null;
			Configuration conf = HBaseConfiguration.create();
			Connection connection = ConnectionFactory.createConnection(conf);
		    Scan scan = new Scan();
		    TableName tableName = TableName.valueOf(args[0]);
		    Table table = connection.getTable(tableName);
		    ResultScanner scanner = table.getScanner(scan);
		    Path path = new Path( args[1]);
		   // SequenceFile.createWriter(fc, conf, name, keyClass, valClass, compressionType, codec, metadata, createFlag, opts)
		    Writer.Option[] opts = new Writer.Option[]
		            { Writer.keyClass(BytesWritable.class), Writer.valueClass(BytesWritable.class), Writer.file(path) };
		    writer = SequenceFile.createWriter(conf, opts);
		    for (Result result = scanner.next(); result != null; result = scanner.next())
		    {
		    byte [] value1 = result.getValue(Bytes.toBytes("d"),Bytes.toBytes("ci"));
		   // System.out.println("The values "+bytesToHex(value1));
		    BytesWritable rrow = new BytesWritable(result.getRow());
		    rrow.setCapacity(result.getRow().length);
		    System.out.println(result.getRow().length);
		    
		    BytesWritable vaalue = new BytesWritable(value1);
		    vaalue.setCapacity(value1.length);
		    System.out.println(value1.length+" "+value1);
		    
	    	writer.append(rrow, vaalue);
	    	//writer.append(Bytes.toBytes("Gangadhar"), Bytes.toBytes("Golla"));
	    	writer.hflush();
		    }
		    scanner.close();
		    /*for(byte[] l : list)
		    {
		    	Get g = new Get(l);
		    	Result result = table.get(g);
		    	byte [] value = result.getValue(Bytes.toBytes("d"),Bytes.toBytes("et"));
		    	
		    	System.out.println("The values "+Bytes.toStringBinary(value1));
		    	writer.append(g.getRow(),value1);
		    }*/
		    System.out.println("Operation is ended");
		    writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                        '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
                v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
}
}
