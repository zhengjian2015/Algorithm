package com.sort;
import java.util.Arrays;

/**
 * 快速排序
 * 设立两个指针，当left<righe的时候，找轴能把数组分成两部分
 * 当左边的数大于轴 和 右边的数小于轴的时候 就交换，
 *
 * 轴
 */
public class QuickSort {
    public void sort(int[] array,int leftBound,int rightBound) {
        if(leftBound >= rightBound) return;
        int mid = partition(array,leftBound,rightBound);
        sort(array,leftBound,mid - 1);
        sort(array,mid+1,rightBound);
    }

    private static int partition(int[] array, int leftBound, int rightBound) {
        int pivoit = array[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && array[left] <= pivoit) left++;
            while (left <= right && array[right] > pivoit) right--;
            if(left < right) swap(array,left,right);
        }
        swap(array,left,rightBound);
       // System.out.println(Arrays.toString(array));
        return left;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(10000,0,10000);
        //System.out.println(Arrays.toString(arr));
        long begin = System.nanoTime();
        new QuickSort().sort(arr,0,arr.length-1);
        long end = System.nanoTime();
        double time = (end - begin)/1000000000.0;
        System.out.println("用时"+time+"s");
        System.out.println(Arrays.toString(arr));
    }
}
