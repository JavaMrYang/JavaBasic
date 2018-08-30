package com.sun.source.util;

import com.sun.source.io.Serializable;

import java.util.Comparator;
import java.util.Objects;

public interface Map<K,V>
{
	int size();
	
	boolean isEmpty();
	
	boolean containsKey(Object key);
	
	boolean containsValue(Object value);
	
	V get(Object key);
	
	V put(K key, V value);
	
	V remove(Object key);
	
	void putAll(Map<? extends K, ? extends V> m);
	
	void clear();
	
	Set<K> keySet();
	
	Collection<V> values();
	
	Set<Map.Entry<K, V>> entrySet();
	
	interface Entry<K,V>{
		
		K getKey();
		
		V getValue();
		
		V setValue(V value);
		
		boolean equals(Object o);
		
		int hashCode();
		
		public static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey(){
			return (Comparator<Map.Entry<K, V>> & Serializable)
					(c1,c2)->c1.getKey().compareTo(c2.getKey());
		}
		
	    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        }
	   
	    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
           Objects.requireNonNull(cmp);
           return (Comparator<Map.Entry<K, V>> & Serializable)
               (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
       }
	    
	    public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
        }
	    
	}
	
	boolean equals(Object o);
	
	int hashCode();
}
