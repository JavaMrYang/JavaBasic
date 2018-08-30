package com.test;

/**
 * 构造行数只能调用一次，String的初始值为null
 * @author Administrator
 *
 */
public class Hello
{
	String title;
	int value;
	public Hello()
	{
		title+=" world";
	}
	public Hello(int value){
		this.value=value;
		title+="hello";
		//Hello();
	}
	public static void main(String[] args)
	{
		Hello h=new Hello(5);
		System.out.println(h.title);
	}
}
