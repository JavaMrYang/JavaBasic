package com.person.test;

public class ObjectTest {
public static int i=100;
public static void go() {
	i++;
}
public static void main(String[] args) {
	go();
	System.out.println(i);
	i++;
	ObjectTest.i++;
	System.out.println(i);
	new ObjectTest().i--;
	System.out.println(i);
}
}
