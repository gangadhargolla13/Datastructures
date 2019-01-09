package com.java.core.linkedlist;

import java.util.ArrayList;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedListImpl ll = new LinkedListImpl();
		ll.add11(12);
		ll.add11(15);
		ll.add11(13);
		ll.add11(16);
		ll.add11(14);
		ll.add11(14);
		ll.add11(13);
		ll.add11(16);
		
		ll.printList();
		ll.removeDuplicates();
//		ll.swap();
//		ll.printList();
		//ll.reverse1();
		//ll.delete1(13);
		//ll.reverse();
		//ll.sorting();
		//ll.printList();
		/*ArrayList<String> m = new ArrayList();
		m.add("ganga");
		m.add("ganga1");
		m.add("ganga2");
		ArrayList<String> m1 = m;
		System.out.println(m);
		System.out.println(m1.hashCode() +" "+m.hashCode());
		m1.add("ganga3");
		System.out.println(m1);
		System.out.println(m);
		ll.printList();
		ll.printList();*/
	}
}

