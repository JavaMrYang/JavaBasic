package com.test;

class A1{
	void foo() throws Exception{
		throw new Exception();
	}
}
class Sub2 extends A1{
	void foo() {
		System.out.println("b");
	}
}
public class Test_05
{
public static void main(String[] args) throws Exception
{
	A1 a=new Sub2();
	a.foo();
}
}
