package com.sun.source.util;

public interface ListIterator<E> extends Iterator<E>
{
	boolean hasNext();

	E next();

	boolean hasPrevious();

	E previous();

	int nextIndex();

	int previousIndex();

	void remove();

	void set(E var1);

	void add(E var1);
}
