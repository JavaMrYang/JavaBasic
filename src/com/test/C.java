package com.test;

interface A{
	void doSomeThing(String name);
}
class AImpl implements A{

	@Override
	public void doSomeThing(String name)
	{
	}
	
}
class B{
	public A doit() {
		return new AImpl();
	}
	public String execute() {
		return null;
	}
}
public class C extends B
{
	public AImpl doit() {
		return new AImpl();
	}
	public String execute() {
		return null;
	}
}
