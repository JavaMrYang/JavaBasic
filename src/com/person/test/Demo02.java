package com.person.test;

public class Demo02 {
public static void main(String[] args) {
	System.out.println("第一个月兔子的对数:"+1);
	System.out.println("第二个月兔子的对数:"+1);
	int f1=1,f2=1,f,M=24;
	for(int i=3;i<=M;i++) {
		f=f1+f2;
		f1=f2;
		f2=f;
		System.out.println("第个"+i+"月兔子的对数:"+f2);
	}
}
}
