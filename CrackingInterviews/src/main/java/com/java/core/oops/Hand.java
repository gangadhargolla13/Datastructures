package com.java.core.oops;

import java.util.ArrayList;

public class Hand<T extends Card> {
	ArrayList<T> hand;
	public Hand() {
		hand = new ArrayList<T>();
	}
	// and more methods here.
}
