package com.ganga.spark.java;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkJobInfo;
import org.apache.spark.SparkStageInfo;
import org.apache.spark.api.java.JavaFutureAction;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;

public class SparkJobStatus {

	public static class IdentityWithdelay<T> implements Function<T,T>{
		@Override
		public T call(T x) throws Exception
		{
			Thread.sleep(2*1000);
			return x;
		}
	}
	public static void main(String[] args) throws Exception{
		SparkSession spark = SparkSession
			      .builder()
			      .master("local")
			      .appName("SparkJobStatus")
			      .getOrCreate();
		JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
		JavaRDD<Integer> rdd = jsc.parallelize(Arrays.asList(1,2,3,4,5),5).map(new IdentityWithdelay());
		JavaFutureAction<List<Integer>> jobF = rdd.collectAsync();
		while(!jobF.isDone())
		{
			Thread.sleep(1000);  // 1 second
		      List<Integer> jobIds = jobF.jobIds();
		      if (jobIds.isEmpty()) {
		        continue;
		      }
		      int currentJobId = jobIds.get(jobIds.size() - 1);
		      SparkJobInfo jobInfo = jsc.statusTracker().getJobInfo(currentJobId);
		      SparkStageInfo stageInfo = jsc.statusTracker().getStageInfo(jobInfo.stageIds()[0]);
		      System.out.println(stageInfo.numTasks() + " tasks total: " + stageInfo.numActiveTasks() +
		          " active, " + stageInfo.numCompletedTasks() + " complete");
		}
		 System.out.println("Job results are: " + jobF.get());
		    spark.stop();
	}
}
