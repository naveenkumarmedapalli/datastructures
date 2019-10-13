/**
 * A map implementation.
 *
 * @author Naveen, naveenkumarmedapalli@gmail.com
 */
package com.nvn.hashmap;

public class MyMap<K, V> {

	Entry<K, V>[] entries;
	private static final int INITIAL_CAPACITY = 16;
	int size;

	MyMap() {
		this(16);
	}

	MyMap(int capacity) {
		entries = new Entry[INITIAL_CAPACITY];
	}

	public void put(K key, V value) {

		int index = hashValue(key);
		// System.out.println("index : " + index);
		Entry<K, V> entry = new Entry<K, V>(key, value, null);

		if (entries[index] == null) {
			entries[index] = entry;
			size++;
		} else {

			Entry<K, V> current = entries[index];

			while (current.next != null) {
				if (current.key.equals(key)) {
					current.value = value;
					return;
				}
				current = current.next;
			}
			if (current.key.equals(key)) {
				current.value = value;
			} else {
				current.next = entry;
				size++;
			}

		}

	}

	public V get(K key) {

		Entry<K, V> entry = entries[hashValue(key)];

		while (entry != null) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
			entry = entry.next;
		}

		return null;
	}

	private int hashValue(K key) {

		// to allow null values
		if (key == null)
			return 0;
		return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
	}

	public int size() {
		return size;
	}

	public boolean containsKey(K key) {
		Entry<K, V> entry = entries[hashValue(key)];
		while (entry != null) {
			if (entry.key.equals(key)) {
				return true;
			}
			entry = entry.next;
		}
		return false;
	}

	public V remove(K key) {
		Entry<K, V> entry = entries[hashValue(key)];
		// System.out.println(entry);
		while (entry != null) {
			Entry<K, V> temp = entry;
			if (entry.key.equals(key)) {
				entries[hashValue(key)] = null;
				--size;
				return temp.value;
			}
			entry = entry.next;
		}
		
		return null;
	}

	public void show() {
		System.out.print("{");
		int i = 0;
		while (i <= INITIAL_CAPACITY - 1) {
			Entry<K, V> entry = entries[i];
			while (entry != null) {
				System.out.print(entry.key + "=" + entry.value + ", ");
				entry = entry.next;
			}
			i++;
		}
		System.out.println("}");
	}

}
