package com.sun.source.util;

import java.util.Objects;
import java.util.function.Predicate;

public interface Collection<E> extends Iterable<E> {
	int size();

	boolean isEmpty();

	boolean contains(Object arg0);

	Iterator<E> iterator();

	Object[] toArray();

	<T> T[] toArray(T[] arg0);

	boolean add(E arg0);

	boolean remove(Object arg0);

	boolean containsAll(Collection<?> arg0);

	boolean addAll(Collection<? extends E> arg0);

	boolean removeAll(Collection<?> arg0);

	default boolean removeIf(Predicate<? super E> arg0) {
		Objects.requireNonNull(arg0);
		boolean arg1 = false;
		Iterator<E> arg2 = this.iterator();

		while (arg2.hasNext()) {
			if (arg0.test(arg2.next())) {
				arg2.remove();
				arg1 = true;
			}
		}

		return arg1;
	}

	boolean retainAll(Collection<?> arg0);

	void clear();

	boolean equals(Object arg0);

	int hashCode();


}
