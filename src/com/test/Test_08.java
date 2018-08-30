package com.test;

class E{
	static void doStaff() {
		System.out.println("e");
	}
}
class F extends E{
	static void doStaff() {
		System.out.println("f");
	}
}
public class Test_08
{
public static void main(String[] args)
{
	E[] es=new E[] {new E(),new F(),new E()};
	for(E e:es) {
		e.doStaff();
	}
}
}
