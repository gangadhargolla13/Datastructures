package com.mapr.ganga.Hbaseoperation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;

public class HbaseReading {

	public static void main(String[] args) {
		try
		{
			System.out.println("Operation is started");
			Configuration conf = HBaseConfiguration.create();
			FileSystem fs = FileSystem.get(conf);
			Path outputPath = new Path(args[1]);
			BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(outputPath)));
			String line;
            line=br.readLine();
            while (line != null){
                    System.out.println(line);
                    line=br.readLine();
            }
		    Connection connection = ConnectionFactory.createConnection(conf);
		    //Admin admin = connection.getAdmin();
		    Scan scan = new Scan();
		    scan.addColumn(Bytes.toBytes("d"), Bytes.toBytes("et"));
		    TableName tableName = TableName.valueOf(args[0]);
		    Table table = connection.getTable(tableName);
		    ResultScanner scanner = table.getScanner(scan);
		    List<byte[]> list = new ArrayList<byte[]>();
		    for (Result result = scanner.next(); result != null; result = scanner.next())
		    	list.add(result.getRow());
		    	//System.out.println("Found row : " + Bytes.toLong(result.getRow()));
		    scanner.close();
		    for(byte[] l : list)
		    {
		    	Get g = new Get(l);
		    	Result result = table.get(g);
		    	byte [] value = result.getValue(Bytes.toBytes("d"),Bytes.toBytes("et"));
		    	byte [] value1 = result.getValue(Bytes.toBytes("d"),Bytes.toBytes("ci"));
		    	//Bytes.toStringBinary(b)
		    	Text t =new Text();
		    	t.toString();
		    	String name = Bytes.toStringBinary(value);
		    	String name1 = Bytes.toStringBinary(value1);
		    	System.out.println("First value "+name);
		    	System.out.println("Second value "+name1);
		    	
		    	
		    }
			System.out.println("Operation is completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
