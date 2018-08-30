package com.pm;

class Person{
	public void makeVoice() {
		System.out.println("animal is make voice");
	}
}
class Man extends Person{
	public void makeVoice() {
		System.out.println("horse is make voice");
	}
	void playDead() {
		System.out.println("roll over");
	}
}
public class CaseTest01
{
public static void main(String[] args)
{
	Person[] ps= {new Person(),new Man(),new Person()};
	for(Person p:ps) {
		p.makeVoice();
		if(p instanceof Man) {
			((Man) p).playDead();
		}
	}
}
}
