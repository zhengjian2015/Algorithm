package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 反转字符串， 看标签是 双指针的思路
 *
 *
 */
public class Solution344 {
    /**
     * 交换位置
     * @param s
     * @return
     */
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while (head < tail) {
            char exchante;
            exchante = s[tail];
            s[tail] = s[head];
            s[head] = exchante;
            head++;
            tail--;
        }
    }


    public char[] reverseString2(char[] s) {
        int length = s.length;
        char[] res = new char[length];
        Map<Integer, Integer> map = new HashMap();
        for (int j = 0; j <= length - 1; j++) {
            map.put(j, length - j - 1);
        }
        for (int i = s.length - 1; i >= 0; i--) {
            res[map.get(i)] = s[i];
        }
        for (int j = 0; j <= length - 1; j++) {
            s[j] = res[j];
        }
        return res;
    }

    public static void main(String[] args) {
        char[] s = {'a','b','c','d','e'};
        new Solution344().reverseString2(s);
        System.out.println(Arrays.toString(s));
    }
}
