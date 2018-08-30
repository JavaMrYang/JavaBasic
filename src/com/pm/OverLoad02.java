package com.pm;

class Alpha{
	Alpha doStuff(char c) {
		return new Alpha();
	}
}
class Beta extends Alpha{
	Beta doStuff(char c) {
		return new Beta();
	}
}
public class OverLoad02
{
public static void main(String[] args)
{
	new Alpha().doStuff('a');
	new Beta().doStuff('c');
}
}
