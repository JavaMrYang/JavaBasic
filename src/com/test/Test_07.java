package com.test;

class Animal{
	String name;
	Animal(String name){
		this.name=name;
	}
	public Animal()
	{
		this(makeRandomName());
	}
	 static String makeRandomName() {
		int i=(int)(Math.random()*5);
		String name=new String[]{"zern","jack","maker","facker"}[i];
		return name;
	}
}
public class Test_07
{
public static void main(String[] args)
{
	Animal a=new Animal("juke");
	System.out.println(a.name);
	Animal b=new Animal();
	System.out.println(b.name);
}
}
