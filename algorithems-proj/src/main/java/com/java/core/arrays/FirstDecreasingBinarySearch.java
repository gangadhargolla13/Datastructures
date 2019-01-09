package com.java.core.arrays;

public class FirstDecreasingBinarySearch {
	public static int find(int[] arrA, int start, int end) {
        if (arrA == null || arrA.length == 0)
            return -1;
        if (start == end)
            return start;
        if (end == start + 1 && arrA[start] > arrA[end])
            return start;
        if (end == start + 1 && arrA[start] < arrA[end])
            return end;

        int mid = start + (end - start) / 2;
        if (arrA[mid] > arrA[mid + 1] && arrA[mid] > arrA[mid - 1])
            return mid;
        else if (arrA[mid] > arrA[mid + 1] && arrA[mid] < arrA[mid - 1]) {
            return find(arrA, start, mid);
        } else //if(arrA[mid]==1){
            return find(arrA, mid + 1, end);
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
        int index = find(arrA, 0, arrA.length - 1);
        System.out.println("(Binary Search) First Element from where elements starts decreasing: (index: "+index+") : " + arrA[index]);
    }
}
