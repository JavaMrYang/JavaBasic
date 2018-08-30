package com.jz;

/**
 * 数据类型的转换
 * @author Administrator
 *
 */
public class Demo02 {
public static void main(String[] args) {
	int money=2000000000;
	int year=20;
	int total1=money*year;
	long total2=money*year;
	long total3=(long)money*year;
	System.out.println(total1);
	System.out.println(total2);
	System.out.println(total3);
	
	//计算一个人70年心跳多少次(假设它每分钟心跳70下)
	int times1=70*60*24*365*70;
	long times2=70l*60*24*365*70;
	System.out.println(times1);
	System.out.println(times2);
}
}
