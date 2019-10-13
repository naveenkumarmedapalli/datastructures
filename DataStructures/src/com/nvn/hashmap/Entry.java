package com.nvn.hashmap;

public class Entry<K, V> {

	K key;
	V value;
	Entry<K, V> next;

	public Entry(K key, V value, Entry<K, V> next) {
		super();
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
	}

}
