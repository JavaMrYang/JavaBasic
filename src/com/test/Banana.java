package com.test;

import java.io.Serializable;

class Food implements Serializable{public int good=3;}
class Fruit extends Food{int juice=5;}
public class Banana extends Fruit
{
 int yellow=4;
 public static void main(String[] args)
{
	Banana b=new Banana();
	
}
}
