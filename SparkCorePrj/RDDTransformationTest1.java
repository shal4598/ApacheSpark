package com.jpmc.training.sparkcore;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDTransformationTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf=new SparkConf();
		conf.setMaster("local[*]");
		conf.setAppName("rdd-transformation-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		JavaRDD<String> testRdd=sc.textFile("c:/test");
		JavaRDD<String> transformedRdd=testRdd.filter(line->line.length()>10).map(line->line.toUpperCase());
		transformedRdd.collect().forEach(System.out::println);
		

	}

}
