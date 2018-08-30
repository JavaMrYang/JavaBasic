package com.pojo;

public enum Type
{
MAMMALS(1,"哺乳动物"),REPTILES(2,"爬行动物"),BIRDS(3,"鸟类"),FISH(4,"鱼"),INSECTS(5,"虫");
private int num;
private String name;

private Type(int num, String name)
{
	this.num = num;
	this.name = name;
}
public int getNum()
{
	return num;
}
public void setNum(int num)
{
	this.num = num;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}


}
