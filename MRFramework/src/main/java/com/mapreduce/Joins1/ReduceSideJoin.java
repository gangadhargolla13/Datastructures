/*package com.mapreduce.Joins1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.contrib.utils.join.DataJoinMapperBase;
import org.apache.hadoop.contrib.utils.join.DataJoinReducerBase;
import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.reducesidejoin.ReduceSideJoin.Map.TaggedWritable;
*//**
 * 
 * @author Rohan Jain
 * This reduce side join job uses the old hadoop API, as there are numerous incompatibility issues with the new API.
 *//*
public class ReduceSideJoin extends Configured implements Tool {
	
	public static class Map extends DataJoinMapperBase {
		public static class TaggedWritable extends TaggedMapOutput{
			private Writable data;
			*//**
			 * Need to Initialize the empty constructor as we have declared a args constructor, otherwise you will
			 * get a NoSuchMethodException error.
			 *//*
			public TaggedWritable(){
				this.tag = new Text();
			}
			public TaggedWritable(Writable data){
				this.tag = new Text(" ");
				this.data = data;
			}
			public Writable getData() {
				return data;
			}
			public void setData(Writable data) {
				this.data = data;
			}
			public void write(DataOutput out) throws IOException {  
	            this.tag.write(out);  
	            out.writeUTF(this.data.getClass().getName());
	            this.data.write(out);  
	        }
			public void readFields(DataInput in) throws IOException {  
		            this.tag.readFields(in);  
		            String dataClz = in.readUTF();  
		            if (this.data == null || !this.data.getClass().getName().equals(dataClz)) {  
		                try {  
		                    this.data = (Writable) ReflectionUtils.newInstance(Class.forName(dataClz), null);  
		                } catch (ClassNotFoundException e) {  
		                    e.printStackTrace();  
		                }  
		            }  
		            this.data.readFields(in);  
		        }  
		}
		
		*//**
		 * Method is used to generate  the tag for different data source using input file name
		 *//*
		public Text generateInputTag(String inputFile){
			String dataSource = inputFile;
			return new Text(dataSource);
		}
		
		*//**
		 *  Method is used to generate the group/join key for different records
		 *//*
		protected Text generateGroupKey(TaggedMapOutput	aRecord){
			String line = ((Text) aRecord.getData()).toString();
			String[] tokens = line.split(",");
			String groupKey = tokens[0];
			return new Text(groupKey);
		}
		
		*//**
		 * 	Since our values are of type custom writable i.e., taggedWritable cast the value as this and
		 *  return the result with input tag attached to each value
		 *//*
		protected TaggedMapOutput generateTaggedMapOutput(Object value){
			TaggedWritable retv = new TaggedWritable((Text) value);
			retv.setTag(this.inputTag);
			return retv;
		}
		
		*//**
		 * For each record in data source file it will call the map function again and pass the record 
		 * to associate a tag attribute with each record of that data source using it's input file name.
		 * So all records of a data source file will get the same tag.
		 * Map function which outputs the key/value pair where key is the JoinKey 
		 * and values are record of type TaggedWritable having an tag attribute associated with them.
		 * @param key
		 * @param value
		 * @param context
		 * @throws IOException
		 * @throws InterruptedException
		 *//*
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void map(Text key,Text value,Context context) throws IOException, InterruptedException{
			TaggedMapOutput aRecord = generateTaggedMapOutput(value);
			Text groupKey = generateGroupKey(aRecord);
			context.write(groupKey, aRecord);
		}
	}
	
	*//**
	 * The reducer function will only have a single combine method, 
	 * which takes the object args of tag list and values wrapped with tags types. 
	 * 
	 *//*
	public static class Reduce extends DataJoinReducerBase {
		protected TaggedMapOutput combine(Object[] tags, Object[] values) {
			if(tags.length<2) return null;
			String joinedStr = "";
			for(int i=0;i<values.length;i++){
				if(i>0) joinedStr += ",";
				TaggedWritable tw = (TaggedWritable) values[i];
				String line = ((Text) tw.getData()).toString();
				String[] tokens = line.split(",",2);
				joinedStr += tokens[1];
			}
			TaggedWritable retv = new TaggedWritable(new Text(joinedStr));
			retv.setTag((Text) tags[0]);
			return retv;
		}
	}
	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new ReduceSideJoin(), args);
		System.exit(res);
	}
	
	public int run(String[] args) throws Exception {
	
		Configuration conf = getConf();
		JobConf job = new JobConf(conf,ReduceSideJoin.class);
		job.setJarByClass(ReduceSideJoin.class);
		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(TaggedWritable.class);
		
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		job.setInputFormat(TextInputFormat.class);
		job.setOutputFormat(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);
		
		JobClient.runJob(job);  
		return 0;  
        }
}
*/