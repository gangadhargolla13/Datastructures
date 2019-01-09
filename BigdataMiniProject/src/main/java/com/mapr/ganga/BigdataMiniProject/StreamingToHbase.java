package com.mapr.ganga.BigdataMiniProject;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.spark.JavaHBaseContext;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import com.google.gson.reflect.TypeToken;

import scala.Tuple2;

public class StreamingToHbase {
	public static void main(String[] args) {
	    if (args.length < 6) {
	      System.err.println("Usage: spark streaming to HBase <zkQuorum> <group> <topics> <numThreads>");
	      System.exit(1);
	    }
	    SparkConf sparkConf = new SparkConf().setAppName("spark streaming to HBase").setMaster("local[2]");

	    JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(5000));

	    final JavaSparkContext context = jssc.sparkContext();
	    Configuration config = HBaseConfiguration.create();
	    JavaHBaseContext hBaseContext = new JavaHBaseContext(context, config);
	    
	    int numThreads = Integer.parseInt(args[3]);
	    Map<String, Integer> topicMap = new HashMap<String, Integer>();
	    String[] topics = args[2].split(",");
	    for (String topic: topics) {
	      topicMap.put(topic, numThreads);
	    }
		
	    JavaPairReceiverInputDStream<String, String> messages =  KafkaUtils.createStream(jssc, args[0], args[1], topicMap);
	    JavaPairDStream<Integer,Integer> nums = messages.mapToPair(new PairFunction<Tuple2<String,String>, Integer, Integer>()
        {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Tuple2<Integer,Integer> call(Tuple2<String, String> tuple2) {
                return new Tuple2<Integer,Integer>(1,Integer.parseInt(tuple2._2()));
            }
        });
	    
	    JavaDStream<Tuple2<Integer,Integer>> countAndSum = nums.reduce(new Function2<Tuple2<Integer,Integer>, Tuple2<Integer,Integer>, Tuple2<Integer,Integer>>() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> a, Tuple2<Integer, Integer> b) {
                return new Tuple2<Integer, Integer>(a._1() + b._1(), a._2() + b._2());
            }
        });

        countAndSum.foreachRDD(new Function<JavaRDD<Tuple2<Integer, Integer>>, Void>() {
            public Void call(JavaRDD<Tuple2<Integer, Integer>> tuple2JavaRDD) throws Exception {
                if (tuple2JavaRDD.count() > 0) {
                    System.out.println("Current avg: " + tuple2JavaRDD.first()._2() / tuple2JavaRDD.first()._1());
                } else {
                    System.out.println("Got no data in this window");
                }
                return null;
            }

			@Override
			public Void apply(JavaRDD<Tuple2<Integer, Integer>> t) {
				// TODO Auto-generated method stub
				return null;
			}
        });
	    JavaPairDStream<String,String> lines = messages.mapToPair(new Function<Tuple2<String, String>, String>() {
	        public String call(Tuple2<String, String> tuple2) {
	          return tuple2._2();
	        }

			@Override
			public String apply(Tuple2<String, String> t) {
				// TODO Auto-generated method stub
				return null;
			}
	      });
	    JavaDStream<PersonBean> lines = messages.map(new Function<Tuple2<String, String>, PersonBean>() {
	    	private static final long serialVersionUID = 1L;
			public PersonBean apply(Tuple2<String, String> t) {
				return null;
			}
	    	public PersonBean call(Tuple2<String, String> tuple2) {
	        	String jsonData = tuple2._2();
	        	TypeToken<PersonBean> token = new TypeToken<PersonBean>() {};
	        	PersonBean model = new PersonBean();
	        	//PersonBean model = gson.fromJson(jsonData, token.getType());
	            return model;
	        }
	      });
	    lines.foreachRDD(new Function<JavaRDD<PersonBean>, Void>() {
	    	public Void call(JavaRDD<PersonBean> personRDD) throws Exception {
	    		pushRawDataToHBase(hBaseContext, personRDD);
				return null;
			}

			@Override
			public Void apply(JavaRDD<PersonBean> t) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	    
	    lines.print();
	    jssc.start();
	  }

}
	  public static void pushRawDataToHBase(JavaHBaseContext hBaseContext, JavaRDD<PersonBean> resultRDD) {
	 
	try{
		hBaseContext.bulkPut(resultRDD, "person", new Function<PersonBean, Put>() {
	 
	private static final long serialVersionUID = 4090513150477943397L;
	//@Override
	@SuppressWarnings("deprecation")
	public Put call(PersonBean dataBean) throws Exception {
		Put put = new Put(Bytes.toBytes(new java.util.Date().getTime()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("UniqueId"), Bytes.toBytes(dataBean.getUid()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("FirstName"), Bytes.toBytes(dataBean.getFirstName()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("LastName"), Bytes.toBytes(dataBean.getLastName()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("City"), Bytes.toBytes(dataBean.getCity()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("Salary"), Bytes.toBytes(dataBean.getSalary()));
		
		return put;
		}
	@Override
	public Put apply(PersonBean t) {
		// TODO Auto-generated method stub
		return null;
	}
	}, true);  
	} catch (Exception e) {
		e.printStackTrace();
		  }
	  }
}

}
