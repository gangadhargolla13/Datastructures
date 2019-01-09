package com.java.core.core;

import java.util.Comparator;

public class ImplementOfComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
