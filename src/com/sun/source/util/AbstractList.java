package com.sun.source.util;

import java.util.RandomAccess;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>
{
protected transient int modCount=0;

public boolean add(E var1) {
	this.add(this.size(), var1);
	return true;
}
public abstract E get(int var1);

public E set(int var1,E var2) {
	throw new UnsupportedOperationException();
}

public void add(int var1,E var2) {
	throw new UnsupportedOperationException();
}

public E remove(int var1) {
	throw new UnsupportedOperationException();
}

public int indexOf(Object var1) {
	ListIterator var2=this.listIterator();
	
	if(var1==null) {
		while(var2.hasNext()) {
			if(var2.next()==null) {
				return var2.previousIndex();
			}
		}
	}else {
		while(var2.hasNext()) {
			if(var2.next().equals(var1)) {
				return var2.previousIndex();
			}
		}
	}
	return -1;
}

public int lastIndexOf(Object var1) {
	ListIterator var2 = this.listIterator(this.size());
	if (var1 == null) {
		while (var2.hasPrevious()) {
			if (var2.previous() == null) {
				return var2.nextIndex();
			}
		}
	} else {
		while (var2.hasPrevious()) {
			if (var1.equals(var2.previous())) {
				return var2.nextIndex();
			}
		}
	}

	return -1;
}

public boolean addAll(int var1, Collection<? extends E> var2) {
	this.rangeCheckForAdd(var1);
	boolean var3 = false;

	for (Iterator var4 = var2.iterator(); var4.hasNext(); var3 = true) {
		Object var5 = var4.next();
		//this.add(var1++, var5);
	}

	return var3;
}

/*public List<E> subList(int var1, int var2) {
	return (List) (this instanceof RandomAccess
			? new RandomAccessSubList(this, var1, var2)
			: new SubList(this, var1, var2));
}*/

public boolean equals(Object var1) {
	if (var1 == this) {
		return true;
	} else if (!(var1 instanceof List)) {
		return false;
	} else {
		ListIterator var2 = this.listIterator();
		ListIterator var3 = ((List) var1).listIterator();

		while (true) {
			if (var2.hasNext() && var3.hasNext()) {
				Object var4 = var2.next();
				Object var5 = var3.next();
				if (var4 == null) {
					if (var5 == null) {
						continue;
					}
				} else if (var4.equals(var5)) {
					continue;
				}

				return false;
			}

			return !var2.hasNext() && !var3.hasNext();
		}
	}
}

public ListIterator<E> listIterator(int var1){
	this.rangeCheckForAdd(var1);
	//return new ListItr(this, var1);
	return this.listIterator();
}

private void rangeCheckForAdd(int var1) {
	if (var1 < 0 || var1 > this.size()) {
		throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
	}
}

public int hashCode() {
	int var1 = 1;

	Object var3;
	for (Iterator var2 = this.iterator(); var2.hasNext(); var1 = 31 * var1 + (var3 == null ? 0 : var3.hashCode())) {
		var3 = var2.next();
	}

	return var1;
}

protected void removeRange(int var1, int var2) {
	ListIterator var3 = this.listIterator(var1);
	int var4 = 0;

	for (int var5 = var2 - var1; var4 < var5; ++var4) {
		var3.next();
		var3.remove();
	}

}

private String outOfBoundsMsg(int var1) {
	return "Index: " + var1 + ", Size: " + this.size();
}
}
