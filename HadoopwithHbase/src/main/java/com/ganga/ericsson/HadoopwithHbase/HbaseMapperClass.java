package com.ganga.ericsson.HadoopwithHbase;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class HbaseMapperClass extends TableMapper<IntWritable, Text> {
	private Connection connection = null;
	private Table table = null;

	protected void setup(Context context) throws IOException {
		System.out.println("Mapper job stated");
		if (connection == null) {
			connection = ConnectionFactory.createConnection(context
					.getConfiguration());
			table = connection.getTable(TableName.valueOf(context
					.getConfiguration().get("tablename")));
		}
		Scan scan = new Scan();
		scan.addFamily(Bytes.toBytes("b"));
		ResultScanner rscanner = table.getScanner(scan);
		for (Result rr = rscanner.next(); rr != null; rr = rscanner.next()) {
			String key = Bytes.toString(rr.getRow());
			Iterator<Cell> iterator = rr.listCells().iterator();
			String header = "Key:\t";
			String data = key + "\t";
			while (iterator.hasNext()) {
				Cell cell = iterator.next();
				header += Bytes.toString(CellUtil.cloneFamily(cell)) + ":"
						+ Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t";
				data += Bytes.toString(CellUtil.cloneValue(cell));
			}
			System.out.println(header);
			System.out.println(data);
		}
	}
	
	protected void map(IntWritable keyIn,Result result,Context context) throws IOException,InterruptedException{
		System.out.println("Mapper jobs is executing");
		String key = Bytes.toString(result.getRow());
		Iterator<Cell> iterator = result.listCells().iterator();
		String header = "Key:\t";
		String data = key + "\t";
		while (iterator.hasNext()) {
			Cell cell = iterator.next();
			header += Bytes.toString(CellUtil.cloneFamily(cell)) + ":"
					+ Bytes.toString(CellUtil.cloneQualifier(cell)) + "\t";
			data += Bytes.toString(CellUtil.cloneValue(cell));
		}
		Text text = new Text();
		text.set(header +" "+data);
		context.write(new IntWritable(1), text);
	}
	
	protected void cleanup(Context context) throws IOException{
		System.out.println("clean up code being called");
		table.close();
		connection.close();
	}
}
