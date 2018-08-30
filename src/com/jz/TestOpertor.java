package com.jz;

/**
 * 算术运算符
 * @author Administrator
 *
 */
public class TestOpertor {
public static void main(String[] args) {
	int m=8;
	int n=4;
	System.out.println(m&n);
	System.out.println(m|n);
	System.out.println(~m);
	System.out.println(m^n);
	
	int a1=3*2*2;
	int a2=3<<2;
	int a3=3<<3;
	int a4=24>>2;
	System.out.println(a1);
	System.out.println(a2);
	System.out.println(a3);
	System.out.println(a4);
}
}
