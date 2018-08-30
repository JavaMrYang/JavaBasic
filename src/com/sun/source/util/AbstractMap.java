package com.sun.source.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMap<K,V> implements Map<K, V>
{

	protected AbstractMap(){
		
	}
	
	public int size() {
		return entrySet().size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean containsValue(Object value) {
		Iterator<Entry<K, V>> i=entrySet().iterator();
		if(value==null) {
			while(i.hasNext()) {
				Entry<K, V> var1=i.next();
				if(var1.getValue()==null) {
					return true;
				}
			}
		}else {
			while(i.hasNext()) {
				Entry<K, V> entry=i.next();
				if(entry.getValue().equals(value))
					return true;
			}
		}
		return false;
	}
	
	public boolean containsKey(Object key) {
		Iterator<Entry<K, V>> i=entrySet().iterator();
		if(key==null) {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(e.getKey()==null)
					return true;
			}
		}else {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(key.equals(e.getKey()))
					return true;
			}
		}
		return false;
	}
	
	public V get(Object key) {
		Iterator<Entry<K, V>> i=entrySet().iterator();
		if(key==null) {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(e.getKey()==null)
					return e.getValue();
			}
		}else {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(e.getKey().equals(key))
					return e.getValue();
			}
		}
		return null;
	}
	
	public V put(K k,V v) {
		throw new UnsupportedOperationException();
	}
	
	public V remove(Object key) {
		Iterator<Entry<K, V>> i=entrySet().iterator();
		Entry<K, V> currentEntry=null;
		if(key==null) {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(e.getKey()==null)
					currentEntry=e;
			}
		}else {
			while(i.hasNext()) {
				Entry<K, V> e=i.next();
				if(e.getKey().equals(key))
					currentEntry=e;
			}
		}
		V oldValue=null;
		if(currentEntry!=null) {
			oldValue=currentEntry.getValue();
			i.remove();
		}
		return oldValue;
		}
	
	 public void putAll(Map<? extends K, ? extends V> m) {
	        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
	            put(e.getKey(), e.getValue());
	    }
	 
	 public void clear() {
		 entrySet().clear();
	 }
	 
	 transient Set<K>        keySet;
	 transient Collection<V> values;
}
