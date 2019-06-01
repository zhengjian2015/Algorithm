package breakely.cs.b;

import com.datastruct.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        boolean[] c = new boolean[3];
        System.out.println(Arrays.toString(c));
        String s = "22";
        System.out.println(c.length);
        //System.out.println(s.leyungth());
        List<Integer> sm = new ArrayList<>();
        sm.add(1);
        if(sm instanceof LinkedList) {
            System.out.println("yews");
        }
        if(sm instanceof ArrayList) {
            System.out.println("arr");
        }
        if(sm instanceof List){
            System.out.println("li");
        }
    }
}
