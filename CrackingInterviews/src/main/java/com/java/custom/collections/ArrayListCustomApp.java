package com.java.custom.collections;

import java.util.Arrays;

public class ArrayListCustomApp {
	public static void main(String... a) {
        ArrayListCustom<Integer> list = new ArrayListCustom<Integer>();
        //Add elements in custom ArrayList
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
	}
}

class ArrayListCustom<E> {

	// Define INITIAL_CAPACITY, size of elements of custom ArrayList
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object elementData[] = {};

	public ArrayListCustom() {
		elementData = new Object[INITIAL_CAPACITY];
	}

	public void add(E e) {
		if (size == elementData.length) {
			ensureCapacity(); // increase current capacity of list, make it
								// double.
		}
		elementData[size++] = e;
	}

	public E get(int index) {
		// if index is negative or greater than size of size, we throw
		// Exception.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		return (E) elementData[index]; // return value on index.
	}

	private void ensureCapacity() {
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	}
}
