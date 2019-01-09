package com.ganga.STDMapReduce;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper extends Mapper<Object, Text, Text, LongWritable> {

	Text phoneNumber = new Text();
	LongWritable durationInMinutes = new LongWritable();

	public void map(Object key, Text value,
			Mapper<Object, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		String[] parts = value.toString().split("[|]");
		if (parts[CDRConstants.STDFlag].equalsIgnoreCase("1")) {

			phoneNumber.set(parts[CDRConstants.fromPhoneNumber]);
			String callEndTime = parts[CDRConstants.callEndTime];
			String callStartTime = parts[CDRConstants.callStartTime];
			long duration = toMillis(callEndTime) - toMillis(callStartTime);
			durationInMinutes.set(duration / (1000 * 60));
			context.write(phoneNumber, durationInMinutes);
		}
	}

	public long toMillis(String date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateFrm = null;
		try {
			dateFrm = format.parse(date);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return dateFrm.getTime();
	}
}