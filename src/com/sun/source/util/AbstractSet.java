package com.sun.source.util;

import java.util.Objects;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>
{
	protected AbstractSet() {
    }
	
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(!(o instanceof Set))
			return false;
		Collection<?> c=(Collection<?>) o;
		if(c.size()!=this.size())
			return false;
		try
		{
			return containsAll(c);
		} catch (ClassCastException unused)   {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
		
	}
	
	public int hashCode() {
		int h=0;
		Iterator<E> it=iterator();
		while(it.hasNext()) {
			E e=it.next();
			if(e!=null)
				h+=e.hashCode();
		}
		return h;
	}
	
	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified=false;
		
		if(this.size()>c.size()) {
			for(Iterator<?> it=this.iterator();it.hasNext();) {
				modified|=remove(it.next());
			}
		}else {
			for(Iterator<?> it=iterator();it.hasNext();) {
				if(c.contains(it.next())) {
					it.remove();
					modified=true;
				}
			}
		}
		return modified;
	}
}
