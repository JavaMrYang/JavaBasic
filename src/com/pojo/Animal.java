package com.pojo;

public class Animal
{
protected Type type;
void eat() {
	System.out.println("animal is eating things");
}
public static void main(String[] args)
{
	Horse h=new Horse();
	h.eat();
	h.type=Type.BIRDS;
	System.out.println(h.type.getName());
}
}
class Horse extends Animal{
	void eat() {
		System.out.println(" horse is eating things");
	}
}
