package com.jpmc.training.sparkcore;

import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class WordCountTestInCluster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf=new SparkConf();
		//conf.setMaster("local[*]");
		conf.setAppName("word-count-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		sc.setLogLevel("WARN");
		JavaRDD<String> linesRdd=sc.textFile("c:/test/words.txt");
		linesRdd.flatMap(line->Arrays.asList(line.split(" ")).iterator())
		.mapToPair(word->new Tuple2<>(word, 1)).reduceByKey((x,y)->x+y).
		repartition(5).collect()
		.forEach(System.out::println);
		
		linesRdd.map(line->line.toUpperCase()).
		repartition(10)
		.collect().forEach(System.out::println);
		
		try {
			Thread.sleep(10*60*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
