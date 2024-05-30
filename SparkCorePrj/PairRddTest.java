package com.jpmc.training.sparkcore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class PairRddTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf conf=new SparkConf();
		conf.setMaster("local[*]");
		conf.setAppName("pair-rdd-transformation-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		List<Tuple2<String, Integer>> list=new ArrayList<>();
		list.add(new Tuple2<>("a",4));
		list.add(new Tuple2<>("c",2));
		list.add(new Tuple2<>("b",3));
		list.add(new Tuple2<>("a",6));
		list.add(new Tuple2<>("c",7));
		JavaPairRDD<String, Integer> testRdd=sc.parallelize(list).
				mapToPair(t->new Tuple2<String,Integer>(t._1,t._2));
		testRdd.reduceByKey((x,y)->x+y).sortByKey().collect().forEach(System.out::println);
		

	}

}
