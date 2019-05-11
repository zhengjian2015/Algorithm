package com.search;

/**
 * 迭代版本
 * 二分查找法，在有序数组arr中查找target
 * 如果找到target,返回它的索引
 * 如果没找到，返回-1
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int n, int target) {
        //在arr[l...r]中查找target
        int l = 0, r = n - 1;
        while (l <= r) {
            //int mid = (l+r)/2;
            //让第1个无bug的出现晚的原因是考虑溢出情况
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            if (target < arr[mid]) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 23, 44, 241};
        int index = new BinarySearch().binarySearch(arr, arr.length, 9);
        System.out.println(index);
    }
}
