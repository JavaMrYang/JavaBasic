package com.thread;

class Thread01 extends Thread{
	private int count=5;
	public Thread01(String name)
	{
		super();
		this.setName(name);
	}
	@Override
	synchronized public void run()
	{
		super.run();
		while(count>0) {
			count--;
			System.out.println("由"+Thread01.currentThread().getName()+"计算,count="+count);
		}
	}
}
public class Test02
{
public static void main(String[] args)
{
	Thread01 t1=new Thread01("A");
	Thread01 t2=new Thread01("B");
	Thread01 t3=new Thread01("C");
	t1.start();
	t2.start();
	t3.start();
}
}
