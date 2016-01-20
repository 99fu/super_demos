package com.wy.hadoop.eighteen;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// �ڵ�һ��Mapper������˴���10000�������
public class Mapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line = value.toString().trim();
		if(line.length()>0){
			String[] arr = line.split(" ");
			int money = Integer.parseInt(arr[1].trim());
			if(money<=10000){
				context.write(new Text(arr[0].trim()), new IntWritable(money));
			}
		}
	}
	
	
}
