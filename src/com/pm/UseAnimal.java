package com.pm;

class Animal{}
class Horse extends Animal{}
public class UseAnimal
{
public static <T> void printObj(T t) {
	System.out.println("this is a "+t.getClass().getName());
}

public static void main(String[] args)
{
	Animal a=new Animal();
	Horse h=new Horse();
	printObj(a);
	printObj(h);
}
}
