package com.jpmc.training.sparkcore;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDCreationTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf=new SparkConf();
		conf.setMaster("local[*]");
		conf.setAppName("rdd-creation-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		/*JavaRDD<String> testRdd=sc.textFile("c:/test");
		List<String> list=testRdd.collect();
		list.forEach(System.out::println);*/
		JavaRDD<Integer> intRdd=sc.parallelize(Arrays.asList(23,22,11,4));
		intRdd.collect().forEach(System.out::println);

	}

}
