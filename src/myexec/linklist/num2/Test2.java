package myexec.linklist.num2;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        SList<Integer> sList = new SList<>();
        for (int i = 0; i < 5; i++) {
            sList.addFirst(i);
        }
        sList.set(7,3);
        System.out.println(sList);
        sList.remove(3);
        System.out.println(sList);

    }
}
