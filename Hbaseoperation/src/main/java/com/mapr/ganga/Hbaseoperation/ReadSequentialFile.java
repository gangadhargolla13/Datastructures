package com.mapr.ganga.Hbaseoperation;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.ReflectionUtils;

public class ReadSequentialFile 
{

	public static void main(String[] args) 
	{
		try
		{
			System.out.println("The Operation is started!");
			   Configuration conf = HBaseConfiguration.create();
			   Connection connection = ConnectionFactory.createConnection(conf);
			   System.out.println("The Operation is completed!");
			   Path path = new Path( args[0]);
			   FileSystem fs = FileSystem.get(conf);
			   SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                       SequenceFile.Reader.file(path));
			   BytesWritable key = (BytesWritable)
				        ReflectionUtils.newInstance(reader.getKeyClass(), conf);
			   BytesWritable value = (BytesWritable)
				        ReflectionUtils.newInstance(reader.getValueClass(), conf);
				     // long position = reader.getPosition();
				      TableName tableName = TableName.valueOf(args[1]);
					    Table table = connection.getTable(tableName);
				      while (reader.next(key, value)) {
				       // String syncSeen = reader.syncSeen() ? "*" : "";
				        System.out.println("Norma "+key.toString());
				        System.out.println("Hex string format "+key.toString());
				        System.out.println("Normal values "+value.toString());
				        System.out.println("Hex string format value "+value.toString());
				        //key.setCapacity(key.copyBytes().length);
				        Get g = new Get(value.getBytes());
		                Result result = table.get(g);
		                if( result != null)
		                {
		                	System.out.println(result.getRow());
		                	System.out.println(result.getValue(Bytes.toBytes("i"), key.getBytes()));
		                }
				       // position = reader.getPosition(); // beginning of next record
				      }
			  /* BytesWritable key1 = new BytesWritable();
			   BytesWritable val = new BytesWritable();
			   while (reader.next(key1, val)) 
			   {
	                System.out.println("Key Value is "+Bytes.toStringBinary(key1.getBytes()));
	                byte[] b= key1.copyBytes();
	                Get g = new Get(b);
	                System.out.println(b.length);
	                Result result = table.get(g);
	                if( result != null)
	                {
	                	System.out.println("Row id"+result.getRow());
	                }
	            }*/
	            reader.close();
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
	
	public static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
                int index = i * 2;
                int v = Integer.parseInt(s.substring(index, index + 2), 16);
                b[i] = (byte) v;
        }
        return b;
}
}
