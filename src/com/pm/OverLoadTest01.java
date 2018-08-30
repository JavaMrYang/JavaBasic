package com.pm;

class A{
	void go() {
		
	}
}
class B{
	String go(int i) {return null;}
}
public class OverLoadTest01
{
 public static void main(String[] args)
{
	System.out.println(new B().go(5));
}
}
