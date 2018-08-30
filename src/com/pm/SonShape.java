package com.pm;

public class SonShape extends ParentShape
{
public void moveShape() {
	System.out.println("moving game piece");
}
public static void main(String[] args)
{
	SonShape ss=new SonShape();
	ss.diasplayShape();
	ss.moveShape();
}
}
