package com.java.arrays;

public class Findnumbers {

	public static void main(String[] args) {
		int min = new Findnumbers().new Find().minNumber(new int[] { 32, 87, 4,29, 3 });
		System.out.println(min);
		int max = new Findnumbers().new Find().maxNumber(new int[] { 32, 87, 4,29, 3 });
		System.out.println(max);
	}

	public class Find {
		public int minNumber(int[] values) {
			System.out.println("Find is minimum values");
			int i, tmp;
			if (values != null && values.length != 0) {
				tmp = values[0];
				for (i = 0; i < values.length; i++) {
					if (tmp > values[i]) {
						tmp = values[i];
					}
				}
				return tmp;
			} else {
				return 0;
			}
		}
		public int maxNumber(int[] values) {
			System.out.println("Find is minimum values");
			int i, tmp;
			if (values != null && values.length != 0) {
				tmp = values[0];
				for (i = 0; i < values.length; i++) {
					if (tmp < values[i]) {
						tmp = values[i];
					}
				}
				return tmp;
			} else {
				return 0;
			}
		}
	}
}
