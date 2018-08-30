package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Drink implements Comparable{
	public String name;
	@Override
	public int compareTo(Object var1)
	{
		return 1;
	}
	
}
public class Test_03
{
public static void main(String[] args)
{
	Drink d1=new Drink();
	Drink d2=new Drink();
	d1.name="Coffee";
	d2.name="Tea";
	TreeSet set=new TreeSet();
	set.add(d1);
	set.add(d2);
	for(Object o:set)
	System.out.println(((Drink)o).name);
	
	List list=new ArrayList<>();
	LinkedList linkList=new LinkedList<>();
	linkList.add(0, "zhangsan");
	list.add(0,"lisi");
}
}
