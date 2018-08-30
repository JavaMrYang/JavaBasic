package com.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TreeSet
{
	enum Example{ONE,TWO,THREE}
public static void main(String[] args)
{
	Collection col1=new ArrayList<>();
	col1.add(Example.ONE);
	col1.add(Example.ONE);
	col1.add(Example.ONE);
	col1.add(Example.TWO);
	col1.add(Example.TWO);
	col1.add(Example.THREE);
	Set set=new HashSet(col1);
	for(Object e:set) {
		System.out.println(((Example)e));
	}
	
	System.out.println(3<<3);
	System.out.println(3>>2);
}
}
