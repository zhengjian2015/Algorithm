package com.sort;

import java.util.Arrays;

//思考java是值传递还是引用传递
public class Test01 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        change(a);
        System.out.println(Arrays.toString(a));

    }

    private static void change(int[] o) {
        o[1] = 4;
    }

}
