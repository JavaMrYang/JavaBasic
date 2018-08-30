package com.person.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
public static void main(String[] args) {
	List<String> nameList=new ArrayList<>();
	nameList.add("java");
	nameList.add("java");
	nameList.add("javc");
	nameList.add("javd");
	nameList.add("jvm");
	removeReList(nameList);
	//nameList.remove("java");
	 Iterator<String> it=nameList.iterator();
	 while(it.hasNext()) {
		 System.out.println(it.next());
	 }
	/*for(String s:nameList) {
		System.out.println(s);
	}*/
}
public static void removeReList(List list) {
	/*for(int i=list.size()-1;i>=0;i--) {
		if("java".equals(list.get(i))) {
			list.remove(i);
		}
	}*/
	for(int i=0;i<list.size();i++) {
		if("java".equals(list.get(i))) {
			list.remove(i);
			i--;
		}
	}
}
}
