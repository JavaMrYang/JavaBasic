package com.thread;

public class MyThread extends Thread
{
@Override
public void run()
{
	super.run();
	System.out.println("mythread");
}
public static void main(String[] args)
{
	MyThread mythead=new MyThread();
	mythead.start();
	System.out.println("运行结束!");

	new Thread(()->System.out.println("java8 语法 start")).start();
}
}
