package com.search;

/**
 * 递归二分查找法
 */
public class BinarySearch2 {
    public int binarySearch(int[] arr, int l, int r, int target) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, r, target);
            } else
                return binarySearch(arr, l, mid - 1, target);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 44, 241};
        int index = new BinarySearch2().binarySearch(arr, 0,arr.length-1, 9);
        System.out.println(index);
    }
}
