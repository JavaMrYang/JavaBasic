package com.classload;

public class ObjectUtil<E> {
private Class<? extends Object> classO;
public void getClass(Object o) {
	classO=o.getClass();
}

}
