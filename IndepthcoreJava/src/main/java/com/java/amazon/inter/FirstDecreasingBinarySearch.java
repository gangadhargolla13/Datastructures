package com.java.amazon.inter;

public class FirstDecreasingBinarySearch {
	public static void main(String[] args) {
		try {
			int [] arrA = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
			int val = find(arrA,0,arrA.length);
			System.out.println("The index value is "+val +" and "+arrA[val]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int find(int[] a, int start, int end) throws Exception {
		if (a == null || a.length == 0) {
			return -1;
		}

		if (start == end)
			return 1;
		if (end == start + 1 && a[start] > a[end])
			return start;
		if (end == start + 1 && a[start] < a[end])
			return end;

		int mid = start + (end - start) / 2;
		if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
			return mid;
		} else if (a[mid] > a[mid + 1] && a[mid] < a[mid - 1]) {
			return find(a, start, mid);
		} else {
			return find(a, mid + 1, end);
		}
	}
}
