package com.mapr.ganga.Hbaseoperation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;

public class FileReader {
	public static void main(String[] args) {
		try
		{
			System.out.println("I am gangadhar");
			Configuration conf = HBaseConfiguration.create();
			FileSystem fs = FileSystem.get(conf);
			Path outputPath = new Path(args[0]);
			Connection connection = ConnectionFactory.createConnection(conf);
			TableName tableName = TableName.valueOf(args[1]);
		    Table table = connection.getTable(tableName);
			BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(outputPath)));
			String line;
	        line=br.readLine();
	        while (line != null){
	                System.out.println(line);
	                String[] ll = line.split("\t");
	    	        System.out.println("String format "+ll[0]);
	    	        Get g = new Get(hexStringToByteArray(ll[0]));
	    	        g.addColumn(Bytes.toBytes("i"), hexStringToByteArray(ll[1]));
	    	        Result result = table.get(g);
	    	        //ImmutableBytesWritable iii = new ImmutableBytesWritable(Bytes.toBytes(ll[1]));
	    	        
	    	        //byte [] value = result.getValue(Bytes.toBytes("i"),iii);
	    	        if(result != null)
	    	        {
	    	        	System.out.println("Its successful!");
	    	        	System.out.println("Row id"+bytesToHex(result.getRow()));
	    	        	System.out.println("Value"+Bytes.toString(result.getValue(Bytes.toBytes("i"), hexStringToByteArray(ll[1]))));
	    	        }
	    	        /*System.out.println("byte format "+ll[0].getBytes());
	    	        System.out.println("String toBytes "+Bytes.toBytes(ll[0]));
	    	        System.out.println("String toBytesBinary "+Bytes.toBytesBinary(ll[0]));*/
	                line=br.readLine();
	                
	        }
	        /*Scan s = new Scan();
	        ResultScanner scanner = table.getScanner(s);
		    for (Result result = scanner.next(); result != null; result = scanner.next())
		    	System.out.println("Found row : " + Bytes.toStringBinary(result.getRow()));
		    scanner.close();*/
	        System.out.println("I am mallikarjuna");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
