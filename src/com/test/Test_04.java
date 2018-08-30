package com.test;

public class Test_04
{
 void waitForSignal() {
	 Object obj=new Object();
	 synchronized(Thread.currentThread()) {
		 //obj.wait();
		 obj.notify();
	 }
 }
 public static void main(String[] args)
{
	new Test_04().waitForSignal();
}
}
