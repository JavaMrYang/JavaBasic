package com.sun.source.util;

import java.util.Objects;
import java.util.function.Consumer;

public interface Iterator<E> {
	boolean hasNext();

	E next();

	default void remove() {
		throw new UnsupportedOperationException("remove");
	}

	default void forEachRemaining(Consumer<? super E> arg0) {
		Objects.requireNonNull(arg0);
		while (this.hasNext()) {
			arg0.accept(this.next());
		}
	}
}
