package com.sun.source.util;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.ArrayList.ArrayListSpliterator;
import java.util.ArrayList.Itr;
import java.util.ArrayList.ListItr;
import java.util.ArrayList.SubList;
import java.util.function.Consumer;

import com.sun.source.io.Serializable;

public class ArrayList<E> extends AbstractList<E> implements List<E>,RandomAccess, Cloneable, Serializable{
	private static final long serialVersionUID = 8683452581122892189L;
	private static final int DEFAULT_CAPACITY=10;
	private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
	transient Object[] elementData;
	private int size;
	private static final int MAX_ARRAY_SIZE = 2147483639;
	
    public ArrayList(int var1)
	{
		if(var1>0) {
			this.elementData=new Object[var1];
		}else {
			if(var1!=0) {
				throw new IllegalArgumentException("Illegal Capacity: " + var1);
			}
			this.elementData=EMPTY_ELEMENTDATA;
		}
	}
    
    public ArrayList()
	{
		this.elementData=DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}
    
    public ArrayList(Collection<E> var1) {
    	this.elementData=var1.toArray();
    	if((this.size=this.elementData.length)!=0) {
    		if(this.elementData.getClass()!=Object[].class) {
    			this.elementData=Arrays.copyOf(this.elementData, this.size,Object[].class);
    		}
    	}else {
    		this.elementData=EMPTY_ELEMENTDATA;
    	}
    }
    
    @Override
	public int size()
	{
		return this.size;
	}
    
    public void trimToSize() {
    	++modCount;
    	if(this.size<this.elementData.length) {
    		this.elementData=this.size==0?DEFAULTCAPACITY_EMPTY_ELEMENTDATA:Arrays.copyOf(this.elementData, this.size);
    	}
    }
    
    public void ensureCapacity(int var1) {
    	int var2=this.elementData!=EMPTY_ELEMENTDATA?0:10;
    	if(var1>var2) {
    		this.ensureExplicatCapacity(var1);
    	}
    }
    
    private void ensureCapacityInternal(int var1) {
    	if(this.elementData==DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
    		var1=Math.max(10, var1);
    	}
    	this.ensureExplicatCapacity(var1);
    }
    
	private void ensureExplicatCapacity(int var1)
	{
		++modCount;
		if(var1-this.elementData.length>0) {
			this.grow(var1);
		}
	}

	private void grow(int var1)
	{
		int var2=this.elementData.length;
		int var3=var2+(var2>>var1);
		if(var3-var1<0) {
			var3=var1;
		}
		
		if(var3-2147483639 > 0) {
			var3 = hugeCapacity(var1);
		}
		this.elementData=Arrays.copyOf(this.elementData, var3);
	}
	
	private static int hugeCapacity(int var0) {
		if (var0 < 0) {
			throw new OutOfMemoryError();
		} else {
			return var0 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
		}
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public boolean contains(Object var1) {
		return this.indexOf(var1)>=0;
	}
	
	public int indexOf(Object var1) {
		if(var1==null) {
			for(int var2=0;var2<this.elementData.length;var2++) {
				if(this.elementData[var2]==null) {
					return var2;
				}
			}
		}else {
			for(int var2=0;var2<this.elementData.length;var2++) {
				if(var1.equals(this.elementData[var2])) {
					return var2;
				}
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object var1) {
		if(var1==null) {
			for(int var2=this.size-1;var2>=0;var2--) {
				if(this.elementData[var2]==null) {
					return var2;
				}
			}
		}else {
			for(int var2=this.size-1;var2>=0;var2--) {
				if(var1.equals(this.elementData[var2])) {
					return var2;
				}
			}
		}
		return -1;
	}
	
	public Object clone() {
		 try
		{
			ArrayList var1=(ArrayList) super.clone();
			var1.elementData=Arrays.copyOf(this.elementData, this.size);
			var1.modCount=0;
			return var1;
		} catch (CloneNotSupportedException var2)
		{
			throw new InternalError(var2);
		}
		 
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(this.elementData, this.size);
	}
	
	public  <T> T[] toArray(T[] var1) {
		if(var1.length<this.size) {
			return (T[]) Arrays.copyOf(this.elementData, this.size,var1.getClass());
		}else {
			System.arraycopy(this.elementData, 0, var1, 0, this.size);
			if(var1.length>this.size) {
				var1[this.size]=null;
			}
		}
		return var1;
	}
	
	E elementData(int var1) {
		return (E) this.elementData[var1];
	}
	
	
	@Override
	public E get(int var1)
	{
		this.rangeCheck(var1);
		return this.elementData(var1);
	}
	public E set(int var1,Object var2) {
		this.rangeCheck(var1);
		Object var3=this.elementData(var1);
		this.elementData[var1]=var2;
		return (E) var3;
	}
	
	public boolean add(Object var1) {
		this.ensureCapacityInternal(this.size+1);
		this.elementData[this.size++]=var1;
		return true;
	}
	
	public void add(int var1,E var2) {
		this.rangeCheckForAdd(var1);
		this.ensureCapacityInternal(this.size+1);
		System.arraycopy(this.elementData, var1, this.elementData, var1+1, this.size-var1);
		this.elementData[var1]=var2;
		++this.size;
	}
	
	public E remove(int index) {
		rangeCheck(index);
		modCount++;
		E oldValue=this.elementData(index);
		int numMoved=size-index-1;
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		elementData[--size]=null;
		return oldValue;
	}
	
	public boolean remove(Object var1) {
		int var2=0;
		if(var1==null) {
			for(var2=0;var2<this.elementData.length;var2++) {
				if(this.elementData[var2]==null) {
					fastRemove(var2);
					return true;
				}
			}
		}else {
			for(var2=0;var2<this.elementData.length;var2++) {
				if(this.elementData[var2].equals(var1)) {
					fastRemove(var2);
					return true;
				}
			}
		}
		return false;
	}
	
	private void fastRemove(int var1) {
		--this.modCount;
		int var2=this.size-var1-1;
		if(var2>0) {
			System.arraycopy(this.elementData, var1+1, this.elementData, var1, var2);
		}
		this.elementData[--this.size]=null;
	}
	
	public void clear() {
		++this.modCount;
		for(int var1=0;var1<this.elementData.length;var1++) {
			this.elementData[var1]=null;
		}
		this.size=0;
	}
	
	public boolean addAll(Collection<? extends E> var1) {
		Object[] var2=var1.toArray();
		int var3=var2.length;
		System.arraycopy(var1, 0, this.elementData, this.size, var3);
		this.size+=var3;
		return var3!=0;
	}
	
	public boolean addAll(int var1,Collection<? extends E> var2) {
		this.rangeCheckForAdd(var1);
		Object[] var3=var2.toArray();
		int var4=var3.length;
		this.ensureExplicatCapacity(this.size+var4);
		int var5=this.size-var1;
		if(var5>0) {
			System.arraycopy(this.elementData, var1, this.elementData, var4+var1, var4);
		}
		System.arraycopy(var3, 0, this.elementData, var1, var4);
		this.size+=var4;
		return var4!=0;
	}
	
	protected void removeRange(int var1,int var2) {
		++this.modCount;
		int var3=this.size-var2;
		System.arraycopy(this.elementData, var2, this.elementData, var1, var3);
		int var4=this.size-(var1-var2);
		for(int var5=var4;var5<this.elementData.length;var5++) {
			this.elementData[var5]=null;
		}
		this.size=var4;
	}
	
	private void rangeCheckForAdd(int var1) {
		if(var1>this.size||var1<0) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
		}
	}
	
	private void rangeCheck(int var1) {
		if(var1<this.size) {
			throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
		}
	}
	private String outOfBoundsMsg(int var1) {
		return "Index:"+var1+"Size:"+this.size;
	}

    public boolean removeAll(Collection<?> var1) {
    	Objects.requireNonNull(var1);
    	return this.batchRemove(var1, false);
    }
    
	private boolean batchRemove(Collection<?> c, boolean complement)
	{
		final Object[] elementData=this.elementData;
		int r=0,w=0;
		boolean modified=false;
		try
		{
			for(;r<size;r++) {
				if(c.contains(elementData[r])==complement) {
					elementData[w++]=elementData[r];
				}
			}
		} finally {
			if(r!=size) {
				System.arraycopy(elementData, r, elementData, w, size-r);
				w+=size-r;
			}
			if(w!=size) {
				for(int i=w;i<size;i++) {
					elementData[i]=null;
				}
				modCount++;
				size=w;
				modified=true;
			}
		}
		return modified;
	}

	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
		int expectedModCount=modCount;
		s.defaultWriteObject();
		s.writeInt(size);
		for(int i=0;i<size;i++) {
			s.writeObject(elementData[i]);
		}
		if(expectedModCount!=modCount) {
			throw new ConcurrentModificationException();
		}
	}
	private void readObject(java.io.ObjectInputStream s)throws java.io.IOException, ClassNotFoundException 
	{
	        elementData = EMPTY_ELEMENTDATA;
	        s.defaultReadObject();
	        s.readInt(); // ignored
	        if (size > 0) {
	            ensureCapacityInternal(size);
	            Object[] a = elementData;
	            for (int i=0; i<size; i++) {
	                a[i] = s.readObject();
	            }
	        }
	}
	
	 
	@Override
	public boolean retainAll(Collection<?> c)
	{
		Objects.requireNonNull(c);
        return batchRemove(c, true);
	}

	public ListIterator<E> listIterator(int var1){
		if(var1<0||this.size>var1)
			throw new IndexOutOfBoundsException("Index:"+var1);
		return new ListItr(index);
	}
	
	@Override
	public ListIterator<E> listIterator()
	{
		 return new ListItr(0);
	}


	@Override
	public Iterator<E> iterator()
	{
		 return new Itr();
	}

	private class Itr implements Iterator<E>{
		int cursor;
		int lastRet=-1;
		int expectedModCount = modCount;
		

		@Override
		public boolean hasNext()
		{
			return cursor!=size;
		}

		@Override
		public E next()
		{
			checkForComodification();
			int i=cursor;
			if(i>=size) {
				throw new NoSuchElementException();
			}
			Object[] elementData=ArrayList.this.elementData;
			if(i>=expectedModCount)
				throw new ConcurrentModificationException();
			cursor=i+1;
			return (E) elementData[lastRet=i];
		}
		
		public void remove() {
			if(lastRet<0)
				throw new IllegalStateException();
			checkForComodification();
			
			try
			{
				ArrayList.this.remove(lastRet);
				cursor=lastRet;
				lastRet=-1;
				expectedModCount=modCount;
			} catch (Exception e)
			{
				 throw new ConcurrentModificationException();
			}
		}
		
		@SuppressWarnings("unchecked")
		public void forEachRemaining(Consumer<? extends E> consumer) {
			Objects.requireNonNull(consumer);
			final int size=ArrayList.this.size;
			int i = cursor;
	        if (i >= size) {
	            return;
	        }
	        final Object[] elementData = ArrayList.this.elementData;
	        if (i >= elementData.length) {
	            throw new ConcurrentModificationException();
	        }
	        while (i != size && modCount == expectedModCount) {
	            consumer.accept((E) elementData[i++]);
	        }
	        // update once at end of iteration to reduce heap write traffic
	        cursor = i;
	        lastRet = i - 1;
	        checkForComodification();
		}

		final void checkForComodification()
		{
			if(expectedModCount!=modCount)
				throw new ConcurrentModificationException();
		}
		
	}

	private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            checkForComodification();

            try {
                int i = cursor;
                ArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

		@Override
		public void forEachRemaining(Consumer<? super E> arg0)
		{
			super.forEachRemaining(arg0);
		}
        
    }

	public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new SubList(this, 0, fromIndex, toIndex);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                               ") > toIndex(" + toIndex + ")");
    }

    private class SubList extends AbstractList<E> implements RandomAccess {
        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;

        SubList(AbstractList<E> parent,
                int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = ArrayList.this.modCount;
        }

        public E set(int index, E e) {
            rangeCheck(index);
            checkForComodification();
            E oldValue = ArrayList.this.elementData(offset + index);
            ArrayList.this.elementData[offset + index] = e;
            return oldValue;
        }

        public E get(int index) {
            rangeCheck(index);
            checkForComodification();
            return ArrayList.this.elementData(offset + index);
        }

        public int size() {
            checkForComodification();
            return this.size;
        }

        public void add(int index, E e) {
            rangeCheckForAdd(index);
            checkForComodification();
            parent.add(parentOffset + index, e);
            this.modCount = parent.modCount;
            this.size++;
        }

        public E remove(int index) {
            rangeCheck(index);
            checkForComodification();
            E result = parent.remove(parentOffset + index);
            this.modCount = parent.modCount;
            this.size--;
            return result;
        }

        protected void removeRange(int fromIndex, int toIndex) {
            checkForComodification();
            parent.removeRange(parentOffset + fromIndex,
                               parentOffset + toIndex);
            this.modCount = parent.modCount;
            this.size -= toIndex - fromIndex;
        }

        public boolean addAll(Collection<? extends E> c) {
            return addAll(this.size, c);
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize==0)
                return false;

            checkForComodification();
            parent.addAll(parentOffset + index, c);
            this.modCount = parent.modCount;
            this.size += cSize;
            return true;
        }

        public Iterator<E> iterator() {
            return listIterator();
        }

        public ListIterator<E> listIterator(final int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            final int offset = this.offset;

            return new ListIterator<E>() {
                int cursor = index;
                int lastRet = -1;
                int expectedModCount = ArrayList.this.modCount;

                public boolean hasNext() {
                    return cursor != SubList.this.size;
                }

                @SuppressWarnings("unchecked")
                public E next() {
                    checkForComodification();
                    int i = cursor;
                    if (i >= SubList.this.size)
                        throw new NoSuchElementException();
                    Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length)
                        throw new ConcurrentModificationException();
                    cursor = i + 1;
                    return (E) elementData[offset + (lastRet = i)];
                }

                public boolean hasPrevious() {
                    return cursor != 0;
                }

                @SuppressWarnings("unchecked")
                public E previous() {
                    checkForComodification();
                    int i = cursor - 1;
                    if (i < 0)
                        throw new NoSuchElementException();
                    Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length)
                        throw new ConcurrentModificationException();
                    cursor = i;
                    return (E) elementData[offset + (lastRet = i)];
                }

                @SuppressWarnings("unchecked")
                public void forEachRemaining(Consumer<? super E> consumer) {
                    Objects.requireNonNull(consumer);
                    final int size = SubList.this.size;
                    int i = cursor;
                    if (i >= size) {
                        return;
                    }
                    final Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    while (i != size && modCount == expectedModCount) {
                        consumer.accept((E) elementData[offset + (i++)]);
                    }
                    // update once at end of iteration to reduce heap write traffic
                    lastRet = cursor = i;
                    checkForComodification();
                }

                public int nextIndex() {
                    return cursor;
                }

                public int previousIndex() {
                    return cursor - 1;
                }

                public void remove() {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        SubList.this.remove(lastRet);
                        cursor = lastRet;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void set(E e) {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        ArrayList.this.set(offset + lastRet, e);
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void add(E e) {
                    checkForComodification();

                    try {
                        int i = cursor;
                        SubList.this.add(i, e);
                        cursor = i + 1;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                final void checkForComodification() {
                    if (expectedModCount != ArrayList.this.modCount)
                        throw new ConcurrentModificationException();
                }
            };
        }

        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubList(this, offset, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private String outOfBoundsMsg(int index) {
            return "Index: "+index+", Size: "+this.size;
        }

        private void checkForComodification() {
            if (ArrayList.this.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }

        public Spliterator<E> spliterator() {
            checkForComodification();
            return new ArrayListSpliterator<E>(ArrayList.this, offset,
                                               offset + this.size, this.modCount);
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        @SuppressWarnings("unchecked")
        final E[] elementData = (E[]) this.elementData;
        final int size = this.size;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

}
