package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> a = new ArrayList<>();

        int c = printSystem(2);
        System.out.println(c);
    }

    private static int printSystem(int i) {
        try {
            int b = 100;
            return b;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("111");
        }
        return 200;
    }
}

