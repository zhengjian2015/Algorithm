package com.debug;

public class DebugTest {
    public static void main(String[] args) {
        int i = 10;
        i++;
        int j = pp(i);
        Long.valueOf(j);
        System.out.println(j);
    }

    public static int pp(int i){
        int j = 1 + (i + 2);
        return j;
    }
}
