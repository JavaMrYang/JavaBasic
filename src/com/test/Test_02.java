package com.test;

public class Test_02
{
	static int count=0;
	int i=0;
	public void changCount() {
		while(i<5) {
			i++;
			count++;
		}
	}
public static void main(String[] args)
{
	Test_02 t2=new Test_02();
	Test_02 t1=new Test_02();
	t1.changCount();
	t2.changCount();
	System.out.println(t1.count+":"+t2.count);
	
	String s="Pen";
	s.toLowerCase();
	s.concat(" Box".toLowerCase());
	System.out.println(s);
	System.out.println(s.substring(3, 5));
}
}
