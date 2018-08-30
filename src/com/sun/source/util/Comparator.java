package com.sun.source.util;



public interface Comparator<T>
{
	int compare(T o1, T o2);
	
	boolean equals(Object obj);

	/*default Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }
	
	default Comparator<T> thenComparing(Comparator<? super T> other) {
        Objects.requireNonNull(other);
        return (Comparator<T> & Serializable) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }
	
	default <U> Comparator<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator)
    {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }*/
}
