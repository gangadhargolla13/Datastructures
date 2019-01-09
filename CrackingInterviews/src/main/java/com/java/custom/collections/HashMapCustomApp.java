package com.java.custom.collections;

public class HashMapCustomApp {
	public static void main(String[] args) {

		HashMapCustom<Employee, Integer> hashMapCustom = new HashMapCustom<Employee, Integer>();
		/*
		 * hashMapCustom.put(new Employee("10", "sam"), 12);
		 * hashMapCustom.put(new Employee("21", "amy"), 121);
		 * hashMapCustom.put(new Employee("31", "rob"), 151);
		 * hashMapCustom.put(new Employee("41", "sam"), 15);
		 * hashMapCustom.put(new Employee("42", "wil"), 89);
		 * 
		 * System.out.println("Display values corresponding to keys>");
		 * System.out.
		 * println("value corresponding to employee with id=21 & name='amy' : "
		 * +hashMapCustom.get(new Employee("21", "amy")));
		 */
	}
}

class HashMapCustom<K, V> {

	private Entry<K, V>[] table;
	private int capacity = 4;

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public HashMapCustom() {
		table = new Entry[capacity];
	}

	public void put(K newKey, V data) {
		if (newKey == null)
			return; // does not allow to store null.

		int hash = hash(newKey);
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // we have reached last entry of bucket.
				if (current.key.equals(newKey)) {
					if (previous == null) { // node has to be insert on first of
											// bucket.
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next; // return value corresponding to key.
			}
			return null; // returns null if key is not found.
		}
	}

	public boolean remove(K deleteKey) {

		int hash = hash(deleteKey);

		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // we have reached last entry node of
										// bucket.
				if (current.key.equals(deleteKey)) {
					if (previous == null) { // delete first entry node.
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}

	}

	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + "   ");
					entry = entry.next;
				}
			}
		}

	}

	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}