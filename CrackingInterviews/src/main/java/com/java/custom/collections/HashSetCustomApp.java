package com.java.custom.collections;

public class HashSetCustomApp {
	public static void main(String[] args) {
		HashSetCustom<Integer> hashSetCustom = new HashSetCustom<Integer>();
		hashSetCustom.add(21);
		hashSetCustom.add(25);
		hashSetCustom.add(30);
		hashSetCustom.add(33);
		hashSetCustom.add(35);

		System.out.println("HashSetCustom contains 21 =" + hashSetCustom.contains(21));
		System.out.println("HashSetCustom contains 51 =" + hashSetCustom.contains(51));
	}
}

class HashSetCustom<E> {

	private HashMapCustom<E, Object> hashMapCustom;

	public HashSetCustom() {
		hashMapCustom = new HashMapCustom<>();
	}

	public boolean contains(E obj) {
		// return hashMapCustom.contains(obj) !=null ? true :false;
		return true;
	}

	public void add(E value) {
		hashMapCustom.put(value, null);
	}

	public void display() {
		// hashMapCustom.displaySet();
	}

	public boolean remove(E obj) {
		return hashMapCustom.remove(obj);
	}
}