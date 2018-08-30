package com.test;

abstract class I{
	abstract void a1();
	void a2() {
		
	}
}
class G extends I{

	@Override
	void a1()
	{
		
	}
	void a2() {
		
	}
	
}
class H extends G{
	void c1() {
		
	}
}
public class Test_10
{
public static void main(String[] args)
{
	I a=new G();
	G x=new H();
	I s=new H();
	a.a1();
	a.a2();
	x.a1();
	x.a2();
	s.a1();
	s.a2();
}
}
