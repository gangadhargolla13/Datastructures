package com.ganga.spark.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

public class SparkWordCount {

	public static  transient int element =1;
	public static void main(String[] args) {
		PropertyConfigurator.configure("C:/Ericsson-Softwares/spark-1.5.1-bin-hadoop2.3/conf/log4j.properties");
		String path ="C://HadoopStack//SparkwithKafka//src//main//resource//loremipsum.txt";
		SparkConf sparkConf = new SparkConf().setAppName("map partitions demo").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = javaSparkContext.textFile(path);
        JavaRDD<String> lowerCaseLines1 = lines.mapPartitions(new FlatMapFunction<Iterator<String>, String>() {
        	
			private static final long serialVersionUID = 1L;
            public Iterator<String> call(Iterator<String> linesPerPartition) throws Exception {
            	System.out.println("I am Gangadhar!");
                List<String> lowerCaseLines = new ArrayList<String>();
                while (linesPerPartition.hasNext()) {
                    String line = linesPerPartition.next();
                    lowerCaseLines.add(line.toLowerCase());
                }
                return lowerCaseLines.iterator();
            }
        });
        System.out.println(lowerCaseLines1.collect());
		/*JavaSparkContext sc = new JavaSparkContext("local", "Gangadhar");
		JavaRDD<String> rddX = sc.parallelize(
                Arrays.asList("Joseph", "Jimmy", "Tina",
                        "Thomas", "James", "Cory",
                        "Christine", "Jackeline", "Juan"), 3);
		JavaPairRDD<Character,Iterable<String>> f = rddX.groupBy(word -> word.charAt(0));
		System.out.println(f.collect());*/
		/*SparkSession spark = SparkSession.builder()
				.appName("SparkWordCount")
				.master("local[1]")
				.getOrCreate();
		JavaRDD<String> rdd = spark.read().textFile(path).javaRDD();
		JavaPairRDD<String,Integer> ch = rdd.mapToPair(s -> {
			return new Tuple2(s.split(" ")[0],1);
		});
System.out.println(ch.reduceByKey((a,b) -> b));*/
		/*JavaSparkContext sc = new JavaSparkContext("local", "Gangadhar");
		JavaRDD<Integer> rddX = sc.parallelize(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                2);
	
		Integer iu = rddX.reduce((acc,n) -> acc+n);
		System.out.println(iu);*/
		
		/*JavaPairRDD<String,Integer> ch = rdd.mapToPair(s -> {
			return new Tuple2(s.split(" ")[0],1);
		});
		System.out.println(ch.collect());
		for(Tuple2 r : ch.collect())
		{
			System.out.println(r._1+" ----> "+r._2);
		}*/
		/*JavaRDD<String> ii = rdd.map(s -> s.substring(0, 7));
		System.out.println(ii.collect());*/
		/*JavaPairRDD<Integer,String> j = rdd.flatMapToPair(lines -> {
			ArrayList<Tuple2<Integer,String>> values = new ArrayList<>();
			for(String ss : lines.split(" "))
			{
				Tuple2<Integer,String> tu = new Tuple2<>(element,ss);
				values.add(tu);
			}
		element++;
		return values.iterator();
		});
		System.out.println(j.collect());
		System.out.println(j.collectAsMap());*/
		/*JavaRDD<String> d = rdd.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
		System.out.println(d.collect());
		List<Partition> l = rdd.partitions();
		System.out.println(l.get(0));
		System.out.println(l.size());*/
		//System.out.println(rdd.partitions());
		//rdd.foreach(s -> System.out.println(s));
	/*JavaRDD<String> r = rdd.filter(s -> {
		if(s.contains("gangadhar")){
			System.out.println("I am gandhar");
			return true;
		}
		else
		{
			System.out.println("I am not gangadhar");
			return false;
		}
	     }
	       );
	System.out.println(r.collect());*/
		/*JavaRDD<String> line = rdd.flatMap(s -> Arrays.asList(s.split(" ")).iterator());
		JavaPairRDD<String,Integer> one = line.mapToPair(s -> new Tuple2(s,1));
		JavaPairRDD<String,Integer> counts = one.reduceByKey((i1,i2) -> i1+i2);
		List<Tuple2<String,Integer>> list = counts.collect();
		for(Tuple2<?,?> a : list)
		{
			System.out.println(a._1()+":"+a._2());
		}*/
		//spark.stop();
	}
}
