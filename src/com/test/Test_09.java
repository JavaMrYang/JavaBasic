package com.test;

class Top{
	public Top(String s) {
		System.out.print("b");
	}
}
class Bottom extends Top{

	public Bottom(String s)
	{
		super(s);
		System.out.print("d");
	}
	
}
public class Test_09
{
	public static void main(String[] args)
	{
		new Bottom("s");
		System.out.println(" ");
	}
}
